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

    private VisitTypeRepository visitTypeRepository;
    private EyeService eyeService;

    public VisitTypeServiceImpl(VisitTypeRepository visitTypeRepository, EyeService eyeService) {
        this.visitTypeRepository = visitTypeRepository;
        this.eyeService = eyeService;
    }

    public VisitType createVisitType(VisitTypeDto visitTypeDto, String type) {
        List<Eye> eyeVisits = this.eyeService.createEyes(visitTypeDto.getEyes());
        VisitType visitType;
        if(type.equalsIgnoreCase("M"))  visitType = new Monture();
        else if(type.equalsIgnoreCase("L"))  visitType = new Lentille();
        else throw new IllegalArgumentException("type of visit not found");
        visitType.setEyes(eyeVisits);
        return this.visitTypeRepository.save(visitType);
    }

    public List<VisitType> createVisitsType(List<VisitTypeDto> visitTypesDto) {
        List<VisitType> visitTypes = new ArrayList<>();
        VisitType monture = createVisitType(visitTypesDto.getFirst(), "M");
        VisitType lentille = createVisitType(visitTypesDto.getLast(), "L");
        visitTypes.add(monture);
        visitTypes.add(lentille);
        return visitTypes;
    }
}
