package com.example.coachMeUp.config;

import com.example.coachMeUp.security.SecurityFilter;
import com.example.coachMeUp.service.UsuarioServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Autowired
    UsuarioServiceImpl usuarioService;

    final String[] PERMISSOES_GERAIS = {
            "/login",
            "/api/v1/usuario/register",
            "/api/v1/courses/{name}",
            "/api/v1/courses/categories/{category}"
    };

    final String[] PERMISSOES_ADMINISTRACAO = {
            "/api/v1/courses/register",
            "/api/v1/courses/delete/{id}",
            "/api/v1/courses/update/{id}",
            "/api/v1/courses/update/{id}",
            "/api/v1/customer/findBy/{id}",
            "/api/v1/customer/delete/{id}"
    };

    final String[] PERMISSOES_ASSINANTES = {
            "/api/v1/customer/register",
            "/api/v1/customer/update/{id}",
            "/api/v1/customer/update/{id}",
            "/api/v1/courses/category/{category}",
            "/api/v1/courses/{name}"
    };

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PERMISSOES_GERAIS).permitAll()
                        .requestMatchers(PERMISSOES_ADMINISTRACAO).hasRole("admin")
                        .requestMatchers(PERMISSOES_ASSINANTES).hasRole("customer")
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    @SneakyThrows
    public AuthenticationManager autheticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
