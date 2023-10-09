package com.example.coachMeUp.config;

import com.example.coachMeUp.security.SecurityFilter;
import com.example.coachMeUp.service.UsuarioServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static com.example.coachMeUp.permissions.AdminPermissions.PERMISSOES_ADMINISTRACAO;
import static com.example.coachMeUp.permissions.CustomerPermissions.PERMISSOES_ASSINANTES;
import static com.example.coachMeUp.permissions.GeneralPermissions.PERMISSOES_GERAIS;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PERMISSOES_GERAIS).permitAll()
                        .requestMatchers(PERMISSOES_ADMINISTRACAO).hasRole("ADMIN")
                        .requestMatchers(PERMISSOES_ASSINANTES).hasRole("CUSTOMER")
                        .anyRequest().authenticated())
                        .addFilterBefore(securityFilter,
                                UsernamePasswordAuthenticationFilter.class)
                .cors(corsCustomizer())
                .build();
    }

    @Bean
    public Customizer<CorsConfigurer<HttpSecurity>> corsCustomizer() {
        return (cors) -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();

            config.addAllowedOrigin("http://localhost:8081");
            config.addAllowedMethod("*");
            config.addAllowedOrigin("*");
            config.setAllowCredentials(true);

            return config;
        });
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
