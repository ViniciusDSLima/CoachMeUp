package com.example.customerservice.controller;

import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
}