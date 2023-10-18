package com.example.coachMeUp.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PACKAGE_COURSE",
            joinColumns = @JoinColumn(name = "ID_PACKAGE"),
            inverseJoinColumns = @JoinColumn(name = "ID_COURSE")
    )
    private List<Course> courses;
}


