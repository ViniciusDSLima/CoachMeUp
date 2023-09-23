package com.example.customerservice.controller;

import com.example.customerservice.request.usuario.UsuarioRequestLogin;
import com.example.customerservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody UsuarioRequestLogin request){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(request));
    }
}
