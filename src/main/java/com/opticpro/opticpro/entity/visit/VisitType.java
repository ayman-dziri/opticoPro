package com.opticpro.opticpro.entity.visit;

import com.opticpro.opticpro.entity.eye.Eye;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public abstract class VisitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;

    @OneToMany(mappedBy = "visitType")
    private List<Eye> eyes = new ArrayList<>();
}
