package com.opticpro.opticpro.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CustomerDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String telephone;

    private String ville;

    private String notes;
}
