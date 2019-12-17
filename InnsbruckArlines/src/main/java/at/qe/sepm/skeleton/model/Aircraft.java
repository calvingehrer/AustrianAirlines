package at.qe.sepm.skeleton.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Entity representing Aircraft
 */

@Entity
public class Aircraft implements Persistable<String>, Serializable {

    @Id
    @Column(length = 100)
    private String aircraftIdentification;

    private AircraftType aircraftType;
    private int requiredPilots;
    private int requiredCrewMembers;
    private int numberOfPassengerSeats;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ElementCollection(targetClass = AircraftType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Aircraft_AircraftType")
    @Enumerated(EnumType.STRING)
    private Set<AircraftType> types;

    public String getAircraftIdentification() {
        return aircraftIdentification;
    }

    public void setAircraftIdentification(String aircraftIdentification) {
        this.aircraftIdentification = aircraftIdentification;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public int getRequiredPilots() {
        return requiredPilots;
    }

    public void setRequiredPilots(int requiredPilots) {
        this.requiredPilots = requiredPilots;
    }

    public int getRequiredCrewMembers() {
        return requiredCrewMembers;
    }

    public void setRequiredCrewMembers(int requiredCrewMembers) {
        this.requiredCrewMembers = requiredCrewMembers;
    }

    public int getNumberOfPassengerSeats() {
        return numberOfPassengerSeats;
    }

    public void setNumberOfPassengerSeats(int numberOfPassengerSeats) {
        this.numberOfPassengerSeats = numberOfPassengerSeats;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date creationDate) {
        this.createDate = creationDate;
    }

    @Override
    public String toString() {
        return "at.qe.sepm.skeleton.model.Aircraft[ id=" + aircraftIdentification + " ]";
    }

    @Override
    public String getId(){
        return getAircraftIdentification();
    }

    @Override
    public boolean isNew(){
        return (null == createDate);
    }
}
