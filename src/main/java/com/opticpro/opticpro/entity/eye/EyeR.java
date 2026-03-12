package com.opticpro.opticpro.entity.eye;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class EyeR extends Eye {
}
