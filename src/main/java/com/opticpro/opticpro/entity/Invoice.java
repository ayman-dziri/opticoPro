package com.opticpro.opticpro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PaymentMethode paymentMethode;

    @Column(nullable = true)
    private double deposit; // avance

    @Column(nullable = true)
    private double balance; // reste

    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceProducts> invoiceProducts = new ArrayList<>();
}
