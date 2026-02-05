package com.opticpro.opticpro.service.visit;

import com.opticpro.opticpro.dto.visit.VisitDetails;
import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.dto.visit.VisitsDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.Visit;

import java.util.List;

public interface VisitService {

    Visit createVisit(Customer customer, VisitRequest visitDto);
    Visit getVisitById(int id);
    List<Visit> getLastVisits();
    VisitsDto listCustomerVisits(Customer customer);
    VisitDetails showVisitByCustomer(Visit visit);
    void deleteVisitById(int id);
}
