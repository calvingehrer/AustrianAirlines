package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.services.AircraftService;
import at.qe.sepm.skeleton.services.FlightService;
import at.qe.sepm.skeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("view")
public class AddFlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private UserService userService;

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
        //aircraft.setAvailable(false);
        //aircraft.setPilots(userService.getPilotsByLocation(flight.getIataCodeDeparture()), aircraft.getRequiredPilots());

        List<User> listOfAllPilotsLocation = new ArrayList<>();
        listOfAllPilotsLocation.addAll(userService.getPilotsByLocation(flight.getIataCodeDeparture()));
        flight.setPilots(listOfAllPilotsLocation, aircraft.getRequiredPilots());

        List<User> listOfAllCrewmembwersLocation= new ArrayList<>();
        listOfAllCrewmembwersLocation.addAll(userService.getAllCrewMembersByLocation(flight.getIataCodeDeparture()));
        flight.setCabinStaff(listOfAllCrewmembwersLocation,aircraft.getRequiredCrewMembers());

        aircraftService.saveAircraft(aircraft);
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
