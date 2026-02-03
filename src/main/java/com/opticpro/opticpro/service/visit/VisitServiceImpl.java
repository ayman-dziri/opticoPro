package com.opticpro.opticpro.service.visit;


import com.opticpro.opticpro.dto.visit.CustomerVisitsDto;
import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.dto.visit.VisitDetails;
import com.opticpro.opticpro.dto.visit.VisitsDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.Visit;
import com.opticpro.opticpro.mapper.VisitMapper;
import com.opticpro.opticpro.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private  final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit createVisit(Customer customer, VisitRequest visitDto) {
        Visit visit = VisitMapper.mapToEntity(visitDto);
        visit.setCustomer(customer);
        return visitRepository.save(visit);
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

    public VisitDetails showVisit(Visit visit) {
        return VisitMapper.mapToVisitDetails(visit);
    }
}
