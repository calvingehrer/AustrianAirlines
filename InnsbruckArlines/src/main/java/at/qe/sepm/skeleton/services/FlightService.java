package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Service for accessing and manipulating flight data.
 */

@Component
@Scope("application")
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Returns a collection of all flights.
     *
     * @return
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Collection<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PreAuthorize("hasAuthority('PILOT') or hasAuthority('CABINSTAFF')")
    public Collection<Flight> getAllFlightsPerStaff(User staff){
        return flightRepository.getFlightsByStaff(staff);
    }

    /**
     * Loads a single flight identified by its flightnumber.
     *
     * @param flightNumber the flightnumber to search for
     * @return the user with the given username
     */
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public Flight loadFlight(String flightNumber) {
        return flightRepository.findFirstByFlightNumber(flightNumber);
    }

    /**
     * Saves the flight.
     *
     * @param flight the flight to save
     * @return the updated flight
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Flight saveFlight(Flight flight){
        if(flight.isNew()){
            flight.setCreateDate(new Date());
        }else{
            flight.setUpdateDate(new Date());
        }
        return flightRepository.save(flight);
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public void addNewFlight(Flight flight) {
        Flight newFlight = new Flight();
        newFlight.setFlightNumber(flight.getFlightNumber());
        newFlight.setIataCodeDeparture(flight.getIataCodeDeparture());
        newFlight.setIataCodeArrival(flight.getIataCodeArrival());
        newFlight.setUtcDepartureTime(flight.getUtcDepartureTime());
        newFlight.setUtcArrivalTime(flight.getUtcArrivalTime());
        newFlight.setDateOfFlight(flight.getDateOfFlight());
        newFlight.setUsedAircraft(flight.getUsedAircraft());
        newFlight.setPilots(flight.getPilots());
        newFlight.setCrew(flight.getCrew());
        saveFlight(newFlight);
    }

    /**
     * Deletes the flight.
     *
     * @param flight the flight to delete
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

}
