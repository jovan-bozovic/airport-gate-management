package com.bozovic.airportgatemanagement.validators;

import com.bozovic.airportgatemanagement.controllers.exceptions.AvailablePeriodNotValidException;

import java.time.Duration;
import java.time.LocalTime;

public class AvailablePeriodValidator {
    public static boolean isAvailablePeriodValid(LocalTime start, LocalTime end) {
        if (Duration.between(start, end).getSeconds() < 0) {
            throw new AvailablePeriodNotValidException();
        }

        return true;
    }
}
