package com.example.customerservice.service;

import com.example.customerservice.domain.models.Usuario;
import com.example.customerservice.request.usuario.UsuarioRequestLogin;
import com.example.customerservice.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    AuthenticationManager authenticationManager;

    TokenService tokenService;

    public List<String> login(@Valid UsuarioRequestLogin request){

        if(request.getEmail() == null){
            throw new NullPointerException("O email e necessario para realizar o login");
        }

        if(request.getPassword() == null){
            throw new NullPointerException("A senha e necessaria para realizar o login");
        }

        
        var username = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        var auth = this.authenticationManager.authenticate(username);

        Usuario usuario = (Usuario) auth.getPrincipal();

        var token = tokenService.generateToken(usuario);

        return Arrays.asList(token,usuario.getEmail());
    }
}
