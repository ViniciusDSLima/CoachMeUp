package com.example.coachMeUp.service;

import com.example.coachMeUp.domain.entities.Usuario;
import com.example.coachMeUp.exceptions.errors.FieldsExcpetions;
import com.example.coachMeUp.request.usuario.UsuarioRequestLogin;
import com.example.coachMeUp.security.TokenService;
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

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new FieldsExcpetions("All fields are required for login");
        }
        
        var username = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        var auth = this.authenticationManager.authenticate(username);

        Usuario usuario = (Usuario) auth.getPrincipal();

        var token = tokenService.generateToken(usuario);

        return Arrays.asList(token,usuario.getEmail());
    }
}
