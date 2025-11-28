package com.opticpro.opticpro.repository;

import com.opticpro.opticpro.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
