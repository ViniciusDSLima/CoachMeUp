package com.example.customerservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.customerservice.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token}")
    private String key;

    public String generateToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(key);
            String token = JWT.create()
                    .withIssuer("CoachMeUp")
                    .withSubject(usuario.getEmail())
                    .withClaim("email", usuario.getEmail())
                    .withExpiresAt(expiartionToken())
                    .sign(algorithm);
            
            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("erro ao criar o token JWt " + e.getMessage());
        }
    }

    public boolean tokenIsValid(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWT.require(algorithm)
                    .withIssuer("CoachMeUp")
                    .build()
                    .verify(token)
                    .getSubject();
            return true;
        } catch (JWTVerificationException e){
            throw new RuntimeException("Erro ao validar o jwt " + e.getMessage());
        }
    }

    public String getClaims(String token) {
        return JWT.decode(token).getClaims().get("email").asString();
    }
    private Instant expiartionToken() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }


}
