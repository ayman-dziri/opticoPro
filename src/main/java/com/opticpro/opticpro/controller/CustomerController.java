package com.opticpro.opticpro.controller;

import com.opticpro.opticpro.dto.CustomerDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = this.customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = this.customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Customer customer = this.customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,
                                                      @RequestBody CustomerDto customerDto
    ){
        Customer customer = this.customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
    }
}