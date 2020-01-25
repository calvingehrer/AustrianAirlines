package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AircraftType;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Controller for the aircraft list view.
 */
@Component
@Scope("view")
public class AircraftListController {

    @Autowired
    private AircraftService aircraftService;
    private String aircraftId = "";

    /**
     * Returns a list of all aircrafts
     * that can be filtered by the aircraftID
     *
     * @return
     */
    public Collection<Aircraft> getAircrafts() {
        if (!aircraftId.equals("")) {
            return aircraftService.getAllAircraftsByAircraftId(aircraftId);
        }
        return aircraftService.getAllAircrafts();
    }

    /**
     * Returns a list of all airbus aircrafts
     * that can be filtered by the aircraftID
     *
     * @return
     */
    public Collection<Aircraft> getAirbus() {
        if (!aircraftId.equals("")) {
            return aircraftService.getAllAircraftsByAircraftId(aircraftId);
        }
        return aircraftService.getAllAirbusAircrafts();
    }

    /**
     * Returns a list of all boeing aircrafts
     * that can be filtered by the aircraftID
     *
     * @return
     */
    public Collection<Aircraft> getBoeing() {
        if (!aircraftId.equals("")) {
            return aircraftService.getAllAircraftsByAircraftId(aircraftId);
        }
        return aircraftService.getAllBoeingAircrafts();
    }

    /**
     * Returns a list of all aircrafts at a given location
     *
     * @return
     */
    public Collection<Aircraft> getAvailableAircrafts(Flight flight) {
        return aircraftService.getAllAvailableAircrafts(flight.getIataCodeDeparture(), flight.getUtcDepartureTime());
    }

    public void resetFilter(){
        this.aircraftId = "";
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }
}
