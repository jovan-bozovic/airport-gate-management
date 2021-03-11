package com.bozovic.airportgatemanagement.controllers;

import com.bozovic.airportgatemanagement.models.Gate;
import com.bozovic.airportgatemanagement.models.GateAssignment;
import com.bozovic.airportgatemanagement.services.GateService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RestController
@RequestMapping("/gates")
public class GatesController extends AbstractController {
    private final GateService gateService;

    public GatesController(@Qualifier("gateServiceImpl") GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gate> get(@PathVariable Integer id) {
        return ResponseEntity.ok().body(gateService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Gate> create(@Valid @RequestBody Gate gate) {
        Gate persistedGate = gateService.create(gate);
        return ResponseEntity.created(getCreatedResourceLocation(persistedGate.getId())).body(persistedGate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gate> update(@PathVariable Integer id, @RequestBody Gate gate) {
        Gate persistedGate = gateService.update(id, gate);
        return ResponseEntity.created(getCreatedResourceLocation(persistedGate.getId())).body(persistedGate);
    }

    @PostMapping("/assigned-flight")
    public ResponseEntity<GateAssignment> assignFlightToGate(@RequestParam String flightNumber) {
        GateAssignment persistedGateAssignment = gateService.assignFlightToGate(flightNumber);
        return ResponseEntity.created(getCreatedResourceLocation(persistedGateAssignment.getId()))
                .body(persistedGateAssignment);
    }

    @GetMapping("/assigned-flight/{gateAssignmentId}")
    public ResponseEntity<GateAssignment> getGateAssignment(@PathVariable Integer gateAssignmentId) {
        return ResponseEntity.ok().body(gateService.getGateAssignment(gateAssignmentId));
    }
}
