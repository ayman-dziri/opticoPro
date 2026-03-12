package com.opticpro.opticpro.entity.visit;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opticpro.opticpro.entity.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime visitDate;

    private String doctorName;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
    private List<VisitType> visitTypes = new ArrayList<>();


    @PrePersist
    private void createVisitDate() {
        this.visitDate = LocalDateTime.now();
    }
}
