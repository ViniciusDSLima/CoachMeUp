package com.example.coachMeUp.repository;

import com.example.coachMeUp.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByNIF(long nif);
}