package com.opticpro.opticpro.entity.vision;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class VisionN extends Vision {
}
