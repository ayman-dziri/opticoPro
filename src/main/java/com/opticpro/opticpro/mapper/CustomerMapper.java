package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.CustomerDto;
import com.opticpro.opticpro.entity.Customer;

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDto customerRequest){
        Customer customer = new Customer();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setTelephone(customerRequest.getTelephone());
        return customer;
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerRequest = new CustomerDto();
        customerRequest.setFirstName(customer.getFirstName());
        customerRequest.setLastName(customer.getLastName());
        customerRequest.setTelephone(customer.getTelephone());
        return customerRequest;
    }

}
