package com.bozovic.airportgatemanagement.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "gates")
public class Gate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @Column(name = "in_use")
    private boolean inUse = true;

    @Column(name = "available_from")
    private LocalTime availableFrom = LocalTime.MIN;

    @Column(name = "available_to")
    private LocalTime availableTo = LocalTime.of(
            LocalTime.MAX.getHour(),
            LocalTime.MAX.getMinute(),
            LocalTime.MAX.getSecond()
    );
}
