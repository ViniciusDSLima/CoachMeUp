package com.example.customerservice.controller;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.request.CustomerUpdateRequest;
import com.example.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerRegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(request));
    }

    @GetMapping("/findBy/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody CustomerUpdateRequest customerUpdateRequest){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(id,customerUpdateRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        customerService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
