package com.example.coachMeUp.service;

import com.example.coachMeUp.DTO.AdressDTO;
import com.example.coachMeUp.DTO.CustomerDTO;
import com.example.coachMeUp.externalApis.Ctt;
import com.example.coachMeUp.domain.entities.Customer;
import com.example.coachMeUp.exceptions.errors.ObjectNotFoundException;
import com.example.coachMeUp.mapper.CustomerMapper;
import com.example.coachMeUp.repository.CustomerRepository;
import com.example.coachMeUp.request.customer.CustomerRegisterRequest;
import com.example.coachMeUp.request.customer.CustomerUpdateRequest;
import com.example.coachMeUp.validations.Validation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.coachMeUp.enums.MensagemCustomer.CUSTOMER_NAO_ENCONTRADO;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private List<Validation> validations;

    private final Ctt cttClient;


    @Transactional
    public CustomerDTO save(CustomerRegisterRequest customerRegisterRequest){

        //Validacao email e password.
        for(Validation valide: validations){
            valide.valideCustomer(customerRegisterRequest);
        }

        boolean codigoPostalValido = validarCodigoPostal(customerRegisterRequest);

        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customerRegisterRequest));

        return CustomerMapper.INSTANCE.toCustomerDto(customer);
    }

    public boolean validarCodigoPostal(CustomerRegisterRequest customer){
        String codigoPostal = customer.getAddress().getCodigoPostal();
        AdressDTO adressDTO = cttClient.buscarCodigoPostal(codigoPostal);

        if(adressDTO != null){
            return true;
        } else{
            return false;
        }
    }

    public CustomerDTO findById(String id){
        return CustomerMapper.INSTANCE.toCustomerDto(customerRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Customer Not Found")));
    }

    @Transactional
    public CustomerDTO update(@NotBlank String id,@Valid CustomerUpdateRequest data){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(CUSTOMER_NAO_ENCONTRADO.getDescription()));

        Customer customerUpdate = customerRepository.getReferenceById(id);
        customerUpdate.updateInfo(data);

        return CustomerMapper.INSTANCE.toCustomerDto(customerUpdate);
    }

    @Transactional
    public void delete(String id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("objeto nao encontrado."));

        customerRepository.deleteById(id);
    }
}
