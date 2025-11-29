package com.opticpro.opticpro.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table
public class InvoiceProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    private double totalHT;
    private double totalTTC;
    private static final int TVA = 20;

    private byte quantity;

    @PrePersist
    @PreUpdate
    private void calculateFields(){
        this.totalHT = this.product.getPrice() * this.quantity; // total des produits
        this.totalTTC = this.totalHT + (this.totalHT * TVA / 100); // total avec tva
    }
}