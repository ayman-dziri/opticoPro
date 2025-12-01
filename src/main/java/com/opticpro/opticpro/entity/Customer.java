package com.opticpro.opticpro.entity;


import com.opticpro.opticpro.entity.visit.Visit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(length = 10)
    private String telephone;

    @Column(length = 15)
    private String ville;

    @Column(nullable = true)
    private String notes;

    @Column(nullable = true)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "customer")
    private List<Visit> visits = new ArrayList<>();

    @PrePersist
    private void onCreat(){
        this.createdAt = LocalDateTime.now();
    }
}
