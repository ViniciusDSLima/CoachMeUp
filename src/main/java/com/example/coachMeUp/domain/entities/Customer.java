package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.domain.address.Address;
import com.example.coachMeUp.enums.CustomerRole;
import com.example.coachMeUp.enums.Flat;
import com.example.coachMeUp.request.customer.CustomerUpdateRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email", "id", "NIF"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
    private String NIF;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Phone> phone;

    @ManyToOne
    @JoinColumn(name = "id_courses")
    private Courses courses;

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
