package at.qe.sepm.skeleton.ui.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.FlightService;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("session")
public class Scheduler implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleEvent event;

    @Autowired
    private FlightService flightService;
    private Collection<Flight> allFlightsPerStaff = new ArrayList<>();

    @PostConstruct
    public void init(){
        eventModel = new DefaultScheduleModel();
        //event = new DefaultScheduleEvent();
        //eventModel.addEvent(event);
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public Collection<Flight> getAllFlightsPerStaff() {
        return allFlightsPerStaff;
    }

    public void setAllFlightsPerStaff(Collection<Flight> allFlightsPerStaff) {
        this.allFlightsPerStaff = allFlightsPerStaff;
    }
}