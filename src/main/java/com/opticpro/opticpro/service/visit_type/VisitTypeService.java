package com.opticpro.opticpro.service.visit_type;

import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.visit.VisitType;

import java.util.List;

public interface VisitTypeService {

    VisitType createVisitType(VisitTypeDto visitTypeDto, String type);
    List<VisitType> createVisitsType(List<VisitTypeDto> visitTypesDto);
}
