package com.opticpro.opticpro.entity.vision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opticpro.opticpro.entity.eye.Eye;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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
    @JsonIgnore
    private Eye eye;
}
