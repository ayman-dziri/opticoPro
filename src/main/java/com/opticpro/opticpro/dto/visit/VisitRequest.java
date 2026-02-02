package com.opticpro.opticpro.dto.visit;


import com.opticpro.opticpro.entity.Customer;
import lombok.Data;

@Data
public class VisitRequest {

    private String doctorName;

    private String observation;

    private Customer customer;
}