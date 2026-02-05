package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.visit.CustomerVisitsDto;
import com.opticpro.opticpro.dto.visit.VisitDetails;
import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.visit.Visit;
import com.opticpro.opticpro.entity.visit.VisitType;
import com.opticpro.opticpro.service.visit_type.VisitTypeService;
import com.opticpro.opticpro.service.visit_type.VisitTypeServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class VisitMapper {

    public static Visit mapToEntity(VisitRequest visitDto) {
        Visit visit = new Visit();
        visit.setObservation(visitDto.getObservation());
        visit.setDoctorName(visitDto.getDoctorName());

        return visit;
    }

    public static CustomerVisitsDto mapToCustomerVisitsDto(Visit visit) {
        CustomerVisitsDto visitsDto = new CustomerVisitsDto();
        visitsDto.setId(visit.getId());
        visitsDto.setVisitDate(visit.getVisitDate());
        visitsDto.setDoctorName(visit.getDoctorName());
        return visitsDto;
    }

    public static VisitDetails mapToVisitDetails(Visit visit) {
        VisitDetails visitDetails = new VisitDetails();
        visitDetails.setVisitDate(visit.getVisitDate());
        visitDetails.setDoctorName(visit.getDoctorName());
        visitDetails.setObservation(visit.getObservation());
        visitDetails.setCustomer(visit.getCustomer());
        visitDetails.setCustomer(visit.getCustomer());
        visitDetails.setVisitTypes(visit.getVisitTypes());
        return visitDetails;
    }
}
