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
        Visit visit = VisitMapper.mapToEntity(visitDto); // mapping doctorName and observation to entity
        visit.setCustomer(customer); // mapping the customer

        VisitTypeDto monture = visitDto.getVisitTypes().get(0); // getting the first visitType from dto
        VisitTypeDto lentille = visitDto.getVisitTypes().get(1); // getting the second visitType from dto
        List<VisitTypeDto> visitTypesDto = new ArrayList<>();
        visitTypesDto.add(lentille); // adding the dtos to a new list
        visitTypesDto.add(monture);
        List<VisitType> visitTypes = this.visitTypeService.createVisitsType(visitTypesDto); // using the visitType service to map the dto to entity
        visit.setVisitTypes(visitTypes);

        return visitRepository.save(visit);
    }

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
