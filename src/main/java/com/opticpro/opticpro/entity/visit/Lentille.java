package com.opticpro.opticpro.entity.visit;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class Lentille extends VisitType {
}
