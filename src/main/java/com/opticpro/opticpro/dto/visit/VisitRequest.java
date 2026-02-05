package com.opticpro.opticpro.dto.visit;


import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.VisitType;
import lombok.Data;

import java.util.List;

@Data
public class VisitRequest {

    private String doctorName;

    private String observation;

    private List<VisitTypeDto> visitTypes;

}