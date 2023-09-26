package com.example.customerservice.controller;

import com.example.customerservice.request.usuario.UsuarioRequestRegister;
import com.example.customerservice.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioRequestRegister request){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.singup(request));
    }
}
