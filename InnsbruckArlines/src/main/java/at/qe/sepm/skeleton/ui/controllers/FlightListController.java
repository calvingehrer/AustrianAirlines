package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Controller for the flight list view.
 */
@Component
@Scope("view")
public class FlightListController {

    @Autowired
    private FlightService flightService;

    /**
     * Returns a list of all flights.
     *
     * @return
     */
    public Collection<Flight> getFlights() {
        return flightService.getAllFlights();
    }

}