package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class AddFlightController {

    @Autowired
    private FlightService flightService;

    /**
     * The new flight to be added to the system
     */
    private Flight flight = new Flight();

    /**
     * The aircraft used for the flight.
     */
    private Aircraft aircraft;

    /**
     * Action to add the flight to the system
     */
    public void add(){
        flightService.addNewFlight(flight);
    }

    public void addAircraft(){
        this.flight.setUsedAircraft(aircraft);
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
