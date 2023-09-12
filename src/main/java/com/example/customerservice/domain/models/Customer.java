package com.example.customerservice.domain.models;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.enums.CustomerRole;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email", "id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;
    private long NIF;
    private long phone;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private CustomerRole role;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime register;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime update;

    public Customer(CustomerRegisterRequest data) {
        this.name = data.getName()
    }
}
