package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.domain.address.Address;
import com.example.coachMeUp.enums.CustomerRole;
import com.example.coachMeUp.enums.Flat;
import com.example.coachMeUp.request.customer.CustomerUpdateRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email", "id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String id;

    private String name;
    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Phone> phone;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_package")
    private Package thisPackage;

    @ManyToMany
    @JsonManagedReference
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "CUSTOMER_COURSE",
            joinColumns = @JoinColumn(name = "ID_CUSTOMER"),
            inverseJoinColumns = @JoinColumn(name = "ID_COURSE")
    )
    private List<Course> courses;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Order order;

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
