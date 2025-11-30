package com.opticpro.opticpro.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Eye {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private byte distance;

    @Column(nullable = true)
    private byte height;

    @Column(nullable = true)
    private byte lentille;

    @ManyToOne
    @JoinColumn(name = "visit_type_id")
    private VisitType visitType;

    @OneToMany(mappedBy = "eye")
    private List<Vision> visions = new ArrayList<>();
}
