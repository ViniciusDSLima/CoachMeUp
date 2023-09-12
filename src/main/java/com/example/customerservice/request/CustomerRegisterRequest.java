package com.example.customerservice.request;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.enums.CustomerRole;
import com.example.customerservice.enums.Flat;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import jakarta.websocket.OnMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequest {
    @NotBlank
    @Min(value = 3, message = "The minimum number of characters for the name is 3")
    @Max(value = 255, message = "The maximum number of characters for the name is 255")
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])(?:([0-9a-zA-Z$*&@#])(?!\\1)){8,}$/i")
    private String password;
    @NotNull
    @Pattern(regexp = "^\\d{8}\\d{1}$")
    private long NIF;
    @NotNull
    @Pattern(regexp = "\\(?\\+[0-9]{1,3}\\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})?"
            , message = "enter a valid cell phone number")
    private long phone;
    @NotNull
    private Address address;
    @NotNull
    private Flat flat;
    @NotNull
    private CustomerRole role;

}
