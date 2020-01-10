package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
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

    /**
     * Returns a list of all aircrafts.
     *
     * @return
     */
    public Collection<Aircraft> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    /**
     * Returns a list of all aircrafts at a given location
     *
     * @return
     */
    public Collection<Aircraft> getAvailableAircrafts(String location) {
        return aircraftService.getAllAvailableAircrafts(location);
    }
}
