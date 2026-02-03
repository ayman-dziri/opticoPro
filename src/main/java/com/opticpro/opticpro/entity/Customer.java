package com.opticpro.opticpro.entity;


import com.opticpro.opticpro.entity.visit.Visit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    @Column(nullable = true)
    private Integer yearOfBirth;

    @Column(length = 14)
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

    @Transient
    public Integer getAge(){
        if(this.yearOfBirth == null)    return null;

        LocalDate currentYear = LocalDate.now();
        if(this.yearOfBirth < currentYear.getYear()) {
            return currentYear.getYear() - this.yearOfBirth;
        }
        else throw new IllegalArgumentException("the year of birth is not validated");
    }

}
