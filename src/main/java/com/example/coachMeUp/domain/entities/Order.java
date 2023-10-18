package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "orders")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime carriedOutAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updatedOut;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime finishedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderPayment orderPayment;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private OrderItem orderItem;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

}
