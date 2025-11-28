package com.opticpro.opticpro.service.customer;

import com.opticpro.opticpro.dto.CustomerDto;
import com.opticpro.opticpro.entity.Customer;
import com.opticpro.opticpro.mapper.CustomerMapper;
import com.opticpro.opticpro.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto createCustomer(CustomerDto customerRequest) {
        Customer customer = CustomerMapper.mapToCustomer(customerRequest);
        Customer savedCustomer = this.customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .toList();
    }

    public Customer getCustomerById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(int id, CustomerDto customerDto) {
        Customer customer = getCustomerById(id);
        customer = CustomerMapper.mapToCustomer(customerDto);
        this.customerRepository.save(customer);
        return customer;
    }

    public void deleteCustomer(int id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        if(customer == null)    return;
        this.customerRepository.delete(customer);
    }

}
