package com.example.coachMeUp.controller;

import com.example.coachMeUp.request.packages.PackageRegisterRequest;
import com.example.coachMeUp.service.PackageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/packages")
@AllArgsConstructor
public class PackageController {

    private PackageService packageService;

    @PostMapping("/register")
    public ResponseEntity registerPackage(@RequestBody @Valid PackageRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(packageService.packageRegister(request));
    }
}
