package com.bozovic.airportgatemanagement.services;

import com.bozovic.airportgatemanagement.controllers.exceptions.GateAssignmentDoesNotExistException;
import com.bozovic.airportgatemanagement.controllers.exceptions.GateDoesNotExistException;
import com.bozovic.airportgatemanagement.controllers.exceptions.GateInUseException;
import com.bozovic.airportgatemanagement.controllers.exceptions.NoAvailableGatesException;
import com.bozovic.airportgatemanagement.models.GateAssignment;
import com.bozovic.airportgatemanagement.models.Gate;
import com.bozovic.airportgatemanagement.repositories.GateAssignmentRepository;
import com.bozovic.airportgatemanagement.repositories.GateRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.bozovic.airportgatemanagement.validators.AvailablePeriodValidator.isAvailablePeriodValid;

@Service
@Component("gateServiceImpl")
public class GateServiceImpl implements GateService {
    private final GateRepository gateRepository;

    private final GateAssignmentRepository gateAssignmentRepository;

    public GateServiceImpl(GateRepository gateRepository, GateAssignmentRepository gateAssignmentRepository) {
        this.gateRepository = gateRepository;
        this.gateAssignmentRepository = gateAssignmentRepository;
    }

    @Override
    public Gate getById(Integer gateId) {
        return gateRepository.findById(gateId).orElseThrow(()-> new GateDoesNotExistException(gateId));
    }

    @Override
    public ArrayList<Gate> getAvailable() {
        return gateRepository.getAvailable();
    }

    @Override
    public GateAssignment getGateAssignment(Integer gateAssignmentId) {
        return gateAssignmentRepository.findById(gateAssignmentId).orElseThrow(()
                -> new GateAssignmentDoesNotExistException(gateAssignmentId));
    }

    @Override
    public Gate create(Gate gate) {
        isAvailablePeriodValid(gate.getAvailableFrom(), gate.getAvailableTo());
        return gateRepository.saveAndFlush(gate);
    }

    @Transactional
    @Override
    public Gate update(Integer gateId, Gate gate) {
        Gate existingGate = getById(gateId);

        isAvailablePeriodValid(gate.getAvailableFrom(), gate.getAvailableTo());

        if (gate.getName() == null) {
            gate.setName(existingGate.getName());
        }

        GateAssignment gateAssignment = gateAssignmentRepository.findByGate(existingGate);

        if (gateAssignment != null && existingGate.isInUse() && !gate.isInUse()) {
            throw new GateInUseException(gateId);
        }

        gate.setId(gateId);

        return gateRepository.saveAndFlush(gate);
    }

    @Transactional
    @Override
    public GateAssignment assignFlightToGate(String flightNumber) {
        ArrayList<Gate> availableGates = getAvailable();

        if (availableGates.isEmpty()) {
            throw new NoAvailableGatesException();
        }

        Gate gate = availableGates.get(0);
        gate.setInUse(true);

        GateAssignment gateAssignment = new GateAssignment();
        gateAssignment.setFlightNumber(flightNumber);
        gateAssignment.setGate(gate);

        return gateAssignmentRepository.saveAndFlush(gateAssignment);
    }
}
