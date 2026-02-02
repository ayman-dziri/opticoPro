package com.opticpro.opticpro.entity.visit;


import com.opticpro.opticpro.entity.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "visit")
    private List<VisitType> visitTypes = new ArrayList<>();


    @PrePersist
    private void createVisitDate() {
        this.visitDate = LocalDateTime.now();
    }
}
