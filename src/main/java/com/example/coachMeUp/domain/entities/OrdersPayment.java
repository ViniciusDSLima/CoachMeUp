package com.example.coachMeUp.domain.entities;

import jakarta.persistence.*;

@Entity
public class OrdersPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;
}
