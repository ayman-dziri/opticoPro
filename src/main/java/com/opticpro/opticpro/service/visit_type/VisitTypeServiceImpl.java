package com.opticpro.opticpro.service.visit_type;


import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.eye.Eye;
import com.opticpro.opticpro.entity.visit.Lentille;
import com.opticpro.opticpro.entity.visit.Monture;
import com.opticpro.opticpro.entity.visit.VisitType;
import com.opticpro.opticpro.repository.VisitTypeRepository;
import com.opticpro.opticpro.service.eye.EyeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitTypeServiceImpl implements VisitTypeService {

    private final VisitTypeRepository visitTypeRepository;
    private final EyeService eyeService;

    public VisitTypeServiceImpl(VisitTypeRepository visitTypeRepository, EyeService eyeService) {
        this.visitTypeRepository = visitTypeRepository;
        this.eyeService = eyeService;
    }

    public VisitType createVisitType(VisitTypeDto visitTypeDto) { // creating one visitType with these eyes
        List<Eye> eyeVisits = this.eyeService.createEyes(visitTypeDto.getEyes());
        VisitType visitType;
        String type = visitTypeDto.getType(); // get the type from dto
        if(type.equalsIgnoreCase("M"))  visitType = new Monture();
        else if(type.equalsIgnoreCase("L"))  visitType = new Lentille();
        else throw new IllegalArgumentException("type of visit not found");

        for(Eye eye : eyeVisits)
        {
            eye.setVisitType(visitType);
        }
        visitType.setEyes(eyeVisits);
        return visitType;
    }

    public List<VisitType> createOneOrTwoVisitsType(List<VisitTypeDto> visitTypesDto) { //create one or two of visitTypes
        if(visitTypesDto == null || visitTypesDto.isEmpty())
            throw new IllegalArgumentException("visit types can not be null or empty");

        if(visitTypesDto.size() > 2)
            throw new IllegalArgumentException("visit types can not be more than 2 visit types");

        List<VisitType> visitTypes = new ArrayList<>();

        for(VisitTypeDto visitTypeDto : visitTypesDto)
        {
            if(visitTypeDto.getType() == null || visitTypeDto.getType().isEmpty())
                throw new IllegalArgumentException("visit types can not be null or empty");

            visitTypes.add(this.createVisitType(visitTypeDto));
        }

        return visitTypes;
    }
}
