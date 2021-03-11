package com.bozovic.airportgatemanagement.controllers.exceptions;

public class GateDoesNotExistException extends RuntimeException {
    public GateDoesNotExistException(Integer id) {
        super(String.format("Gate with ID %s does not exist.", id));
    }
}
