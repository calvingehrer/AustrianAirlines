package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.User;
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
    private String aircrafttype = "";
    private String aircraftId = "";

    /**
     * Returns a list of all aircrafts.
     *
     * @return
     */
    public Collection<Aircraft> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    /**
     * Returns a list of aircrafts filtered by  aircraft type/id or
     * all aircraft if no filter is given
     *
     * @return
     */
    public Collection<Aircraft> getFilteredAircrafts(){
        if(!aircraftId.equals("")){
            return aircraftService.getAllAircraftsByAircraftId(aircraftId);
        }
        return aircraftService.getAllAircraftsByType(aircrafttype);
    }


    /**
     * Returns a list of all aircrafts at a given location
     *
     * @return
     */
    public Collection<Aircraft> getAvailableAircrafts(String location) {
        return aircraftService.getAllAvailableAircrafts(location);
    }

    public String getAircrafttype() {
        return aircrafttype;
    }

    public void setAircrafttype(String aircrafttype) {
        this.aircrafttype = aircrafttype;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }
}
