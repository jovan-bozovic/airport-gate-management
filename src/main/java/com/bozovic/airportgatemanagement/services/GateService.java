package com.bozovic.airportgatemanagement.services;

import com.bozovic.airportgatemanagement.models.Gate;
import com.bozovic.airportgatemanagement.models.GateAssignment;

import java.util.ArrayList;

public interface GateService {
    Gate getById(Integer id);

    Gate create(Gate gate);

    Gate update(Integer gateId, Gate gate);

    ArrayList<Gate> getAvailable();

    GateAssignment assignFlightToGate(String flightNumber);

    GateAssignment getGateAssignment(Integer id);
}
