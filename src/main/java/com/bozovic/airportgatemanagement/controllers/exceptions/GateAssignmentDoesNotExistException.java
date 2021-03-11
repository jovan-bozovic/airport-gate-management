package com.bozovic.airportgatemanagement.controllers.exceptions;

public class GateAssignmentDoesNotExistException extends RuntimeException {
    public GateAssignmentDoesNotExistException(Integer id) {
        super(String.format("Gate Assignment with ID %s does not exist.", id));
    }
}
