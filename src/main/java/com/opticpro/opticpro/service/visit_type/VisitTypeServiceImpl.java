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
        return visitType;
    }

    public List<VisitType> createOneOrTwoVisitsType(List<VisitTypeDto> visitTypesDto) { //create one or two of visitTypes
        if(visitTypesDto == null || visitTypesDto.isEmpty()) {
            throw new IllegalArgumentException("visit types can not be null or empty");
        }

        VisitTypeDto firstVisitType = visitTypesDto.get(0); // get monture entered by user
        VisitType monture = createVisitType(firstVisitType, "M"); // create monture to add it to the list
        List<VisitType> visitTypes = new ArrayList<>();
        visitTypes.add(monture); // add monture to the list

        if(visitTypesDto.size() == 1) // if user entered just one visit type (monture OR lentille)
            return visitTypes;

        VisitTypeDto secondVisitType = visitTypesDto.get(1); // get lentille entered by user
        VisitType lentille = createVisitType(secondVisitType, "L"); // create lentille to add it to the list
        visitTypes.add(lentille); // add lentille to the list

        return visitTypes;
    }
}
