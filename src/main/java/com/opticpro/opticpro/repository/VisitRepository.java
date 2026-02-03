package com.opticpro.opticpro.repository;

import com.opticpro.opticpro.entity.visit.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
