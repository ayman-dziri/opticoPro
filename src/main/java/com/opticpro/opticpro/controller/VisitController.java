package com.opticpro.opticpro.controller;

import com.opticpro.opticpro.dto.visit.VisitDetails;
import com.opticpro.opticpro.dto.visit.VisitRequest;
import com.opticpro.opticpro.dto.visit.VisitsDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.entity.visit.Visit;
import com.opticpro.opticpro.service.customer.CustomerService;
import com.opticpro.opticpro.service.visit.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class VisitController {

    private final VisitService visitService;
    private final CustomerService customerService;

    public VisitController(VisitService visitService, CustomerService customerService) {
        this.visitService = visitService;
        this.customerService = customerService;
    }

    @PostMapping("customers/{customerId}/visit")
    public ResponseEntity<Visit> createVisit(@RequestBody VisitRequest visitRequest,
                                             @PathVariable int customerId) {
        Customer customer = this.customerService.getCustomerById(customerId);
        Visit visit = this.visitService.createVisit(customer, visitRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(visit);
    }

    @GetMapping("customers/{customerId}/visits")
    public ResponseEntity<VisitsDto> getCustomerVisits(@PathVariable int customerId) {

        Customer customer = this.customerService.getCustomerById(customerId);
        VisitsDto visitsDto = this.visitService.listCustomerVisits(customer);
        return ResponseEntity.ok(visitsDto);
    }

    @GetMapping("/visit/{id}")
    public ResponseEntity<VisitDetails> showVisit(@PathVariable int id) {
        Visit visit = this.visitService.getVisitById(id);
        VisitDetails visitDetails = this.visitService.showVisitByCustomer(visit);
        return ResponseEntity.ok(visitDetails);
    }

    @GetMapping("/visits")
    public ResponseEntity<List<Visit>> listLastVisits() { // list 10 last visits
        List<Visit> visits = this.visitService.getLastVisits();
        return ResponseEntity.ok(visits);
    }

    @DeleteMapping({"visit/{id}"})
    public void deleteVisit(@PathVariable int id) {
        this.visitService.deleteVisitById(id);
    }
}