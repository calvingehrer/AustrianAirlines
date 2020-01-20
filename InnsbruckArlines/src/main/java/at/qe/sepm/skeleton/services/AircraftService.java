package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AircraftType;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import at.qe.sepm.skeleton.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * Service for accessing and manipulating the available fleet.
 */

@Component
@Scope("application")
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    /**
     * Returns a collection of all aircrafts.
     *
     * @return
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Collection<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<Aircraft> getAllAircraftsByAircraftId(String aircraftId){
        return aircraftRepository.findAircraftByIdPrefix(aircraftId);
    }

    /**
     * Returns a list of all airbus aircrafts
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<Aircraft> getAllAirbusAircrafts(){
            return aircraftRepository.findAircraftByType(AircraftType.AIRBUS);
    }

    /**
     * Returns a list of all airbus aircrafts
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<Aircraft> getAllBoeingAircrafts(){
        return aircraftRepository.findAircraftByType(AircraftType.BOEING);
    }



    /**
     * Returns a collection of all available aircrafts
     *
     * @return
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Collection<Aircraft> getAllAvailableAircrafts(String location){
        return aircraftRepository.findByLocation(location);
    }


    /**
     * Loads a single aircraft identified by its aircraftIdentification.
     *
     * @param aircraftIdentification the aircraftIdentification to search for
     * @return the aircraft with the given aircraftIdentification
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Aircraft loadAircraft(String aircraftIdentification) {
        return aircraftRepository.findFirstByAircraftIdentification(aircraftIdentification);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void addNewAircraft(Aircraft aircraft) {
        Aircraft newAircraft = new Aircraft();
        newAircraft.setAircraftIdentification(aircraft.getAircraftIdentification());
        newAircraft.setAircraftType(aircraft.getAircraftType());
        newAircraft.setRequiredPilots(aircraft.getRequiredPilots());
        newAircraft.setRequiredCrewMembers(aircraft.getRequiredCrewMembers());
        newAircraft.setNumberOfPassengerSeats(aircraft.getNumberOfPassengerSeats());
        newAircraft.setLocation(aircraft.getLocation());
        saveAircraft(newAircraft);
    }

    /**
     * Saves the aircraft.
     *
     * @param aircraft the aircraft to save
     * @return the updated aircraft
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public Aircraft saveAircraft(Aircraft aircraft){
        if(aircraft.isNew()){
            aircraft.setCreateDate(new Date());
        }else{
            aircraft.setUpdateDate(new Date());
        }
        return aircraftRepository.save(aircraft);
    }

    /**
     * Deletes the aircraft.
     *
     * @param aircraft the aircraft to delete
     */
    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('ADMIN')")
    public void deleteAircraft(Aircraft aircraft) {
        aircraftRepository.delete(aircraft);
    }
}
