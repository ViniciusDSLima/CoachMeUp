package com.example.customerservice.domain.address;

import com.example.customerservice.exceptions.errors.IvalidFieldsException;
import com.example.customerservice.request.DataAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private int postalCode;
    private String houseNumber;
    private String parish;
    private String municipalities;
    private String district;
    private String complement;

    public Address(DataAddress address) {
        this.street = address.getStreet();
        this.postalCode = address.getPostalCode();
        this.houseNumber = address.getHouseNumber();
        this.parish = address.getParish();
        this.municipalities = address.getMunicipalities();
        this.district = address.getDistrict();
        this.complement = address.getComplement();
    }

// REFATORACAO PARA A API "IBGE"

    public void updateInfo(DataAddress address){
        if(address.getStreet() != null) this.street = address.getStreet();
        if(address.getPostalCode() != 0) this.postalCode = address.getPostalCode();
        if(address.getHouseNumber() != null) this.houseNumber = address.getHouseNumber();
        if(address.getParish() != null) this.parish = address.getParish();
        if(address.getMunicipalities() != null) this.municipalities = address.getMunicipalities();
        if(address.getDistrict() != null) this.district = address.getDistrict();
        if(address.getComplement() != null) this.complement = address.getComplement();
    }

}
