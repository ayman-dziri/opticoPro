package com.opticpro.opticpro.dto.visit;

import com.opticpro.opticpro.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class VisitsDto {

    private Customer customer;

    private List<CustomerVisitsDto> customerVisits;
}
