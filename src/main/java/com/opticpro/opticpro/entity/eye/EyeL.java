package com.opticpro.opticpro.entity.eye;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class EyeL extends Eye {
}
