package com.example.customerservice.externalApis;

import com.example.customerservice.DTO.AdressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://www.cttcodigopostal.pt/api/v1/4419153811ec44ceb2ff1519c43664/codigoPostal", name = "CTT")
public interface Ctt {

    @GetMapping("/{codigoPostal}")
    AdressDTO buscarCodigoPostal(@PathVariable String codigoPostal);
}
