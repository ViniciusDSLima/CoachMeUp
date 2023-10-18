package com.example.coachMeUp.repository;

import com.example.coachMeUp.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
