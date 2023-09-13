package com.example.customerservice.domain.models;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.enums.CustomerRole;
import com.example.customerservice.enums.Flat;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.request.CustomerUpdateRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private String phone;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private CustomerRole role;
    @Enumerated(EnumType.STRING)
    private Flat flat;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime register;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime update;

    public Customer(CustomerRegisterRequest data) {
        this.name = data.getName();
        this.email = data.getEmail();
        this.password = data.getPassword();
        this.NIF = data.getNIF();
        this.phone = data.getPhone();
        this.address = new Address(data.getAddress());
        this.role = getRole();
        this.register = LocalDateTime.now();
    }

    public void updateInfo(CustomerUpdateRequest data) {
        if(data.getName() != null) this.name = data.getName();
        if(data.getEmail() != null) this.email = data.getEmail();
        if(data.getPassword() != null) this.password = data.getPassword();
        if(data.getPhone() != null) this.phone = data.getPhone();
        if(data.getAddress() != null) this.address.updateInfo(data.getAddress());
        this.update = LocalDateTime.now();
    }
}
