package com.opticpro.opticpro.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private double price;

    @Column(nullable = true)
    private String category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvoiceProducts> invoiceProducts = new ArrayList<>();
}
