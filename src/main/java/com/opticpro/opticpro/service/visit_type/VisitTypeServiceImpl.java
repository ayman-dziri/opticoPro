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

    public VisitType createVisitType(VisitTypeDto visitTypeDto, String type) { // creating one visitType with these eyes
        List<Eye> eyeVisits = this.eyeService.createEyes(visitTypeDto.getEyes());
        VisitType visitType;
        if(type.equalsIgnoreCase("M"))  visitType = new Monture();
        else if(type.equalsIgnoreCase("L"))  visitType = new Lentille();
        else throw new IllegalArgumentException("type of visit not found");
        visitType.setEyes(eyeVisits);
        return this.visitTypeRepository.save(visitType);
    }

    public List<VisitType> createVisitsType(List<VisitTypeDto> visitTypesDto) { //creating the two visitTypes
        if(visitTypesDto == null || visitTypesDto.isEmpty()) {
            throw new IllegalArgumentException("visit types can not be null or empty");
        }

        List<VisitType> visitTypes = new ArrayList<>();
        VisitTypeDto firstVisitType = visitTypesDto.get(0);
        VisitTypeDto secondVisitType = visitTypesDto.get(1);

        VisitType monture = createVisitType(firstVisitType, "M");// adding monture to visitType
        VisitType lentille = createVisitType(secondVisitType, "L");// adding lentille to visitType
        visitTypes.add(monture);
        visitTypes.add(lentille);

        return visitTypes;
    }
}
