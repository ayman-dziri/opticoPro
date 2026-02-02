package com.opticpro.opticpro.service.visit;

import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.Visit;

public interface VisitService {

    Visit createVisit(Customer customer, VisitRequest visitDto);
}
