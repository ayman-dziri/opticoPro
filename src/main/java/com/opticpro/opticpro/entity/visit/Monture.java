package com.opticpro.opticpro.entity.visit;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Monture extends VisitType {

}
