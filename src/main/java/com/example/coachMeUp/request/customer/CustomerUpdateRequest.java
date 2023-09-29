package com.example.coachMeUp.request.customer;

import com.example.coachMeUp.domain.entities.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})[A-Za-z0-9!~<>,;:_=?*+#.”&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]{8,32}$",
            message = "A senha exige de 4 a 32 caracteres, Letras maiusculas e minusculas, numeros e caracteres especiais.")
    private String password;
    private List<Phone> phone;
    private DataAddress address;
}
