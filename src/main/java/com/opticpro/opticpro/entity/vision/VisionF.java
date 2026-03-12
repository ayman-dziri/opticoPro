package com.opticpro.opticpro.entity.vision;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class VisionF extends Vision {
}
