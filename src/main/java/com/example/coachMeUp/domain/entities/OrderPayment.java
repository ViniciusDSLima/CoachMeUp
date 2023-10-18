package com.example.coachMeUp.domain.entities;

import jakarta.persistence.*;

@Entity
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;
}
