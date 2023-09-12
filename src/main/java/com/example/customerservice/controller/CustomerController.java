package com.example.customerservice.controller;

import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerRegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(request));
    }
}
