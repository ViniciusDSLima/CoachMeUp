package com.example.coachMeUp.externalApis;

import com.example.coachMeUp.DTO.AdressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://www.cttcodigopostal.pt/api/v1/4419153811ec44ceb2ff1519c436648f", name = "CTT")
public interface Ctt {

    @GetMapping("/{codigoPostal}")
    List<AdressDTO> buscarCodigoPostal(@PathVariable String codigoPostal);
}
