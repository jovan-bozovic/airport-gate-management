package com.bozovic.airportgatemanagement.controllers.exceptions;

public class GateInUseException extends RuntimeException {
    public GateInUseException(Integer id) {
        super(String.format("Gate with ID %s is in use currently.", id));
    }
}
