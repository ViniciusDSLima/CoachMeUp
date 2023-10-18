package com.example.coachMeUp.request.order;

import com.example.coachMeUp.domain.entities.OrderItem;
import com.example.coachMeUp.enums.PaymentTypes;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class OrdersCreateRequest {
    @NotNull
    private Long id_course;
    @NotNull
    private BigDecimal totalPrice;
    @NotNull
    private OrderItem orderItem;
    @NotNull
    private PaymentTypes paymentType;


}
