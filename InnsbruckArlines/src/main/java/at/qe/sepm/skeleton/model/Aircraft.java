package at.qe.sepm.skeleton.model;

public class Aircraft {
    private String aircraftIdentification;
    private AircraftType aircraftType;
    private int requiredPilots;
    private int requiredCrewMembers;
    private int numberOfPassengerSeats;

    public Aircraft(String aircraftIdentification, AircraftType aircraftType, int requiredPilots, int requiredCrewMembers, int numberOfPassengerSeats) {
        this.aircraftIdentification = aircraftIdentification;
        this.aircraftType = aircraftType;
        this.requiredPilots = requiredPilots;
        this.requiredCrewMembers = requiredCrewMembers;
        this.numberOfPassengerSeats = numberOfPassengerSeats;
    }

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
}
