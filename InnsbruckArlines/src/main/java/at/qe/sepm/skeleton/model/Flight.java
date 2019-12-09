package at.qe.sepm.skeleton.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Flight implements Serializable {
    private String flightNumber;
    private String iataCode;
    private Date utcDepartureTime;
    private Date utcArrivalTime;
    private Date dateOfFlight;
    private List<User> pilots;
    private List<User> groundStaff;
    private int numberOfPassengerSeats;
    private Aircraft usedAircraft;

    public Flight(String flightNumber, String iataCode, Date utcDepartureTime, Date utcArrivalTime, Date dateOfFlight, int numberOfPassengerSeats, Aircraft usedAircraft) {
        this.flightNumber = flightNumber;
        this.iataCode = iataCode;
        this.utcDepartureTime = utcDepartureTime;
        this.utcArrivalTime = utcArrivalTime;
        this.dateOfFlight = dateOfFlight;
        this.numberOfPassengerSeats = numberOfPassengerSeats;
        this.usedAircraft = usedAircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Date getUtcDepartureTime() {
        return utcDepartureTime;
    }

    public void setUtcDepartureTime(Date utcDepartureTime) {
        this.utcDepartureTime = utcDepartureTime;
    }

    public Date getUtcArrivalTime() {
        return utcArrivalTime;
    }

    public void setUtcArrivalTime(Date utcArrivalTime) {
        this.utcArrivalTime = utcArrivalTime;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public List<User> getPilots() {
        return pilots;
    }

    public void setPilots(List<User> pilots) {
        this.pilots = pilots;
    }

    public List<User> getGroundStaff() {
        return groundStaff;
    }

    public void setGroundStaff(List<User> groundStaff) {
        this.groundStaff = groundStaff;
    }

    public int getNumberOfPassengerSeats() {
        return numberOfPassengerSeats;
    }

    public void setNumberOfPassengerSeats(int numberOfPassengerSeats) {
        this.numberOfPassengerSeats = numberOfPassengerSeats;
    }

    public Aircraft getUsedAircraft() {
        return usedAircraft;
    }

    public void setUsedAircraft(Aircraft usedAircraft) {
        this.usedAircraft = usedAircraft;
    }
}