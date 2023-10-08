package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.enums.StagesPayment;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_courses")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrdersPayment> ordersPayments;

    @Enumerated(EnumType.STRING)
    private StagesPayment stagesPayment;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime carriedOutAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime finishedAt;


}
