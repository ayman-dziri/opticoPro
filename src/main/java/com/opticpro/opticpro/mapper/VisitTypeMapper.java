package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.visit.Lentille;
import com.opticpro.opticpro.entity.visit.Monture;
import com.opticpro.opticpro.entity.visit.VisitType;

public class VisitTypeMapper {

    public static VisitType mapToEntity(VisitTypeDto visitTypeDto, String type) {
        VisitType visitType = null;
        if(type.equalsIgnoreCase("M"))  visitType = new Monture();
        else if(type.equalsIgnoreCase("L")) visitType = new Lentille();
        else throw new IllegalArgumentException("type of visit not found");
        return visitType;

    }

}
