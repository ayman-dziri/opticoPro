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
@DiscriminatorColumn(name = "VISION_KIND")
@Table
public abstract class Vision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte sphere;

    private byte cylinder;

    private byte axe;

    private byte addition;

    @ManyToOne
    @JoinColumn(name = "eye_id")
    @JsonIgnore
    private Eye eye;
}
