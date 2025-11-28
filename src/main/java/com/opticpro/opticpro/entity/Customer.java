package com.opticpro.opticpro.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String telephone;
}
