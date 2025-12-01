package com.opticpro.opticpro.service.customer;

import com.opticpro.opticpro.dto.CustomerDto;
import com.opticpro.opticpro.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CustomerDto customerRequest);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer updateCustomer(int id, CustomerDto customerDto);
    void deleteCustomer(int id);
}
