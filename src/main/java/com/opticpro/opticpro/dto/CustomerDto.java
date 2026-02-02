package com.opticpro.opticpro.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class CustomerDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Integer yearOfBirth;

    @NotNull
    @Pattern(
            regexp = "^(0\\d{9}|\\+\\d{13})$",
            message = "Numéro invalide : 0XXXXXXXXX ou +XXXXXXXXXXXX"
    )
    private String telephone;

    private String ville;

    private String notes;
}
