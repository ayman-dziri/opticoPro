package com.opticpro.opticpro.service.visit;


import com.opticpro.opticpro.dto.visit.CustomerVisitsDto;
import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.dto.visit.VisitDetails;
import com.opticpro.opticpro.dto.visit.VisitsDto;
import com.opticpro.opticpro.dto.visit_type.VisitTypeDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.Visit;
import com.opticpro.opticpro.entity.visit.VisitType;
import com.opticpro.opticpro.mapper.VisitMapper;
import com.opticpro.opticpro.repository.VisitRepository;
import com.opticpro.opticpro.service.visit_type.VisitTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitTypeService visitTypeService;

    public VisitServiceImpl(VisitRepository visitRepository, VisitTypeService visitTypeService) {
        this.visitRepository = visitRepository;
        this.visitTypeService = visitTypeService;
    }

    public Visit createVisit(Customer customer, VisitRequest visitDto) {
        Visit visit = VisitMapper.mapToEntity(visitDto); // map doctorName and observation to entity
        visit.setCustomer(customer); // map the customer

        List<VisitTypeDto> visitTypesDto = visitDto.getVisitTypes();
        List<VisitType> visitTypes = this.visitTypeService.createOneOrTwoVisitsType(visitTypesDto); // use the visitType service to map the dto to entity
        for(VisitType visitType : visitTypes)
        {
            visitType.setVisit(visit);
        }
        visit.setVisitTypes(visitTypes);

        return visitRepository.save(visit);
    }

//    private static List<VisitTypeDto> getVisitTypeDtoList(VisitRequest visitDto) {
//        List<VisitTypeDto> existingVisitTypesDto = visitDto.getVisitTypes(); // get the visit types that the customer has entered
//        VisitTypeDto monture;
//        VisitTypeDto lentille;
//        System.out.println("la visite type est : ");
//        if(existingVisitTypesDto.size() == 1) // si y a pas de lentille, juste monture on retourne ce dto saisie
//        {
//            System.out.println("1) " + existingVisitTypesDto);
//            return existingVisitTypesDto;
//        }
//        else if(existingVisitTypesDto.isEmpty())
//        {
//            System.out.println("2) " + existingVisitTypesDto);
//            return null;
//        }
//        else{
//            monture = existingVisitTypesDto.get(0); // get the first visitType from dto
//            lentille = existingVisitTypesDto.get(1); // get the second visitType from dto
//        }
//
//        List<VisitTypeDto> visitTypesDto = new ArrayList<>();
//        if(monture != null)    visitTypesDto.add(monture); // add the dtos to the new list
//        if(lentille != null)    visitTypesDto.add(lentille);
//        System.out.println("3) " + visitTypesDto);
//        return visitTypesDto;
//    }

    public Visit getVisitById(int id) {
        return visitRepository.findById(id).orElse(null);
    }

    public List<Visit> getLastVisits() {
        return visitRepository.findTop10ByOrderByVisitDateDesc();
    }

    public VisitsDto listCustomerVisits(Customer customer) {
        List<Visit> customerVisits = customer.getVisits();
        List<CustomerVisitsDto> customerVisitsDto = new ArrayList<>();
        for(Visit visit : customerVisits) {
            CustomerVisitsDto visitDto = VisitMapper.mapToCustomerVisitsDto(visit);
            customerVisitsDto.add(visitDto);
        }
        VisitsDto visitsDto = new VisitsDto();
        visitsDto.setCustomer(customer);
        visitsDto.setCustomerVisits(customerVisitsDto);
        return visitsDto;
    }

    public VisitDetails showVisitByCustomer(Visit visit) {
        return VisitMapper.mapToVisitDetails(visit);
    }

    public void deleteVisitById(int id) {
        visitRepository.deleteById(id);
    }
}
