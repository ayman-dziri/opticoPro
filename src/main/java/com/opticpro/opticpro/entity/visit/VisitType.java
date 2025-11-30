package com.opticpro.opticpro.entity.visit;

import com.opticpro.opticpro.entity.eye.Eye;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public abstract class VisitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "visitType")
    private List<Eye> eyes;
}
