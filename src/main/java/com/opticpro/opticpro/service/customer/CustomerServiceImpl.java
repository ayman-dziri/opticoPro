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

    public Customer createCustomer(CustomerDto customerRequest) {
        String customerTel = customerRequest.getTelephone();
        int sizeOfTel = customerTel.length();
        if(customerTel.startsWith("0") && sizeOfTel != 10) {
            throw new IllegalArgumentException("invalid telephone number (10 numbers)");
        }
        if(customerTel.startsWith("+") && sizeOfTel < 11) {
            throw new IllegalArgumentException("invalid telephone number ( MIN : 11)");
        }
        if(customerTel.startsWith("+") && sizeOfTel > 14) {
            throw new IllegalArgumentException("invalid telephone number ( MAX : 14)");
        }
        Customer customer = CustomerMapper.mapToCustomer(customerRequest);
        return this.customerRepository.save(customer);
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
        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        if(customer == null)    return;
        this.customerRepository.delete(customer);
    }

}
