package com.example.customerservice.domain.models;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.enums.CustomerRole;
import com.example.customerservice.enums.Flat;
import com.example.customerservice.request.customer.CustomerUpdateRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email", "id", "NIF"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityScan
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private long NIF;
    private String phone;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private CustomerRole role;
    @Enumerated(EnumType.STRING)
    private Flat flat;
    @Column(nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime register;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime updated;


    public void updateInfo(CustomerUpdateRequest data) {
        if(data.getName() != null) this.name = data.getName();
        if(data.getEmail() != null) this.email = data.getEmail();
        if(data.getPassword() != null) this.password = data.getPassword();
        if(data.getPhone() != null) this.phone = data.getPhone();
        if(data.getAddress() != null) this.address.updateInfo(data.getAddress());
        this.updated = LocalDateTime.now();
    }
}
