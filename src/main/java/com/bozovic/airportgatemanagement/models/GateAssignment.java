package com.bozovic.airportgatemanagement.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "gate_assignments")
public class GateAssignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Flight number is a required parameter")
    @Column(name = "flight_number")
    private String flightNumber;

    @OneToOne
    @JoinColumn(name="gate_id", referencedColumnName = "id")
    private Gate gate;
}
