package com.opticpro.opticpro.repository;

import com.opticpro.opticpro.entity.visit.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findTop10ByOrderByVisitDateDesc();
    Visit findByCustomerId(int customerId);
}
