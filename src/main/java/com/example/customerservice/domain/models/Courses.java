package com.example.customerservice.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.math.BigDecimal;

@Entity
@Table(name = "courses", uniqueConstraints =
            @UniqueConstraint(columnNames = "id"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal price;
}
