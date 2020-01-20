package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AircraftType;
import at.qe.sepm.skeleton.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("view")
public class AddAircraftController {

    @Autowired
    private AircraftService aircraftService;

    /**
     * The new aircraft to be added to the system
     */
    private Aircraft aircraft = new Aircraft();

    private String aircraftType;

    /**
     * Action to add the aircraft to the system
     */
    public void add() {
        if (aircraftType.equals("Boeing")){
            aircraft.setAircraftType(AircraftType.BOEING);
        }else if (aircraftType.equals("Airbus")){
            aircraft.setAircraftType(AircraftType.AIRBUS);
        }

        aircraftService.addNewAircraft(aircraft);
        this.aircraft = new Aircraft();
        aircraftType = null;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }


    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }
}
