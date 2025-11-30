package com.opticpro.opticpro.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Vision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private byte sphere;

    @Column(nullable = true)
    private byte cylinder;

    @Column(nullable = true)
    private byte axe;

    @Column(nullable = true)
    private byte addition;

    @ManyToOne
    @JoinColumn(name = "eye_id")
    private Eye eye;
}
