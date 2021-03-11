package com.bozovic.airportgatemanagement.controllers.exceptions;

public class AvailablePeriodNotValidException extends RuntimeException {
    public AvailablePeriodNotValidException() {
        super("End of the available period can not be before start.");
    }
}
