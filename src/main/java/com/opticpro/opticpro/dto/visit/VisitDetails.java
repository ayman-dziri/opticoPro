package com.opticpro.opticpro.dto.visit;


import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.VisitType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class VisitDetails {

    private LocalDateTime visitDate;

    private String doctorName;

    private String observation;

    private Customer customer;

    private List<VisitType> visitTypes = new ArrayList<>();

}
