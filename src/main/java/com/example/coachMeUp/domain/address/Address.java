package com.example.coachMeUp.domain.address;

import com.example.coachMeUp.request.customer.DataAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String morada;
    private String codigoPostal;
    private String porta;
    private String freguesia;
    private String concelho;
    private String distrito;
    private String localidade;

    public void updateInfo(DataAddress address){
        if(address.getMorada() != null) this.morada = address.getMorada();
        if(address.getCodigoPostal() != null) this.codigoPostal = address.getCodigoPostal();
        if(address.getPorta() != null) this.porta = address.getPorta();
        if(address.getFreguesia() != null) this.freguesia = address.getFreguesia();
        if(address.getConcelho() != null) this.concelho = address.getConcelho();
        if(address.getDistrito() != null) this.distrito = address.getDistrito();
        if(address.getLocalidade() != null) this.localidade = address.getLocalidade();
    }

}
