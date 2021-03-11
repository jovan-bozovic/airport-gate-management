package com.bozovic.airportgatemanagement.controllers.exceptions;

public class NoAvailableGatesException extends RuntimeException {
    public NoAvailableGatesException() {
        super("No available gates at the moment.");
    }
}
