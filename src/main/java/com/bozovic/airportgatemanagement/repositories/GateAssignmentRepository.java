package com.bozovic.airportgatemanagement.repositories;

import com.bozovic.airportgatemanagement.models.Gate;
import com.bozovic.airportgatemanagement.models.GateAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateAssignmentRepository extends JpaRepository<GateAssignment, Integer> {
    GateAssignment findByGate(Gate gate);
}
