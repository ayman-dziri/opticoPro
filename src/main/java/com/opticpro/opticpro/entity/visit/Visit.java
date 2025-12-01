package com.opticpro.opticpro.entity.visit;


import com.opticpro.opticpro.entity.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime visitDate;

    @Column(nullable = true)
    private String doctorName;

    @Column(nullable = true)
    private String observation;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @PrePersist
    private void updateVisitDate() {
        this.visitDate = LocalDateTime.now();
    }
}
