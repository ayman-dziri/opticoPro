package com.opticpro.opticpro.entity.visit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opticpro.opticpro.entity.eye.Eye;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "visit-kind")
public abstract class VisitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "visit_id", nullable = false)
    @JsonIgnore
    private Visit visit;

    @OneToMany(mappedBy = "visitType", cascade = CascadeType.ALL)
    private List<Eye> eyes = new ArrayList<>();
}
