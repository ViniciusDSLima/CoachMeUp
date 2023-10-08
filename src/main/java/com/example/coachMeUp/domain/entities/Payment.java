package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.enums.PaymentTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "payment",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentTypes paymentTypes;

    @OneToMany(mappedBy = "payment")
    private List<OrdersPayment> ordersPayments;
}
