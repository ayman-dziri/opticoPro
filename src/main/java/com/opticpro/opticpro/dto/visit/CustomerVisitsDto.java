package com.opticpro.opticpro.dto.visit;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CustomerVisitsDto {

    private int id;

    private LocalDateTime visitDate;

    private String doctorName;
}
