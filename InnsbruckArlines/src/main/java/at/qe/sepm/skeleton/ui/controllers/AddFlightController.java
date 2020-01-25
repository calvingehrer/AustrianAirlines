package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import at.qe.sepm.skeleton.services.AircraftService;
import at.qe.sepm.skeleton.services.FlightService;
import at.qe.sepm.skeleton.services.UserMailService;
import at.qe.sepm.skeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Scope("view")
public class AddFlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMailService userMailService;

    private static int autoIncrementId = 4;

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
        setAutoincrementId();
        flight.setPilots(allocateStaff(UserRole.PILOT, aircraft.getRequiredPilots()));
        flight.setCrew(allocateStaff(UserRole.CABINSTAFF, aircraft.getRequiredCrewMembers()));
        aircraft.setAvailable(false);
        aircraftService.saveAircraft(aircraft);
        flightService.addNewFlight(flight);
    }

    public void addAircraft(){
        this.flight.setUsedAircraft(aircraft);
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setAutoincrementId () {
        if(autoIncrementId < 10) {
            flight.setFlightNumber("F000" + autoIncrementId);
        } else if (autoIncrementId < 100) {
            flight.setFlightNumber("F00" + autoIncrementId);
        } else {
            flight.setFlightNumber("F0" + autoIncrementId);
        }
        autoIncrementId++;
    }

    /**
     * creates a random collection of pilots/crew members
     * to allocate the pilots/crew positions for the flight
     *
     * @param role
     * @param required
     * @return
     */
    public Collection<User> allocateStaff(UserRole role, int required){
        Collection<User> allAvailableStaff = userService.getAllAvailableStaff(role);
        Collection<User> allocatedStaff = new ArrayList<>();

        for(int i = 0; i < required; i++){
            User staff = allAvailableStaff.iterator().next();
            allocatedStaff.add(staff);
            allAvailableStaff.remove(staff);
            //userMailService.sendMailTo(staff, "New Flight Event", "Dear " + staff.getFirstName() + "\n\n you have been added to flight "
            //        + this.flight.getFlightNumber() + " starting at " + this.flight.getUtcDepartureTime() + ".\n\nHave a safe flight,\n Innsbruck Airlines Service Team");
        }
        return allocatedStaff;
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

    public int getAutoIncrementId() {
        return autoIncrementId;
    }

    public void setAutoIncrementId(int autoIncrementId) {
        this.autoIncrementId = autoIncrementId;
    }
}
