package com.opticpro.opticpro.entity.eye;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opticpro.opticpro.entity.vision.Vision;
import com.opticpro.opticpro.entity.visit.VisitType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "eye_kind")
public abstract class Eye {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte distance;

    private byte height;

    private byte lentille;

    @ManyToOne
    @JoinColumn(name = "visit_type_id")
    @JsonIgnore
    private VisitType visitType;

    @OneToMany(mappedBy = "eye", cascade = CascadeType.ALL)
    private List<Vision> visions = new ArrayList<>();
}
