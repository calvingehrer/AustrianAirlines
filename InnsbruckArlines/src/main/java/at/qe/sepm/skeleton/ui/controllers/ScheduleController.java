package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.FlightService;
import at.qe.sepm.skeleton.ui.beans.SessionInfoBean;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Component
@Scope("session")
public class ScheduleController implements Serializable {

    @Autowired
    private FlightService flightService;
    @Autowired
    private SessionInfoBean sessionInfoBean;

    private ScheduleModel lazyEventModel;

    private Flight flight;

    @PostConstruct
    public void init() {
        this.lazyEventModel = new LazyScheduleModel() {

            @Override
            public void loadEvents(Date start, Date end) {

                Collection<Flight> flights = flightService.getAllFlightsPerStaff(sessionInfoBean.getCurrentUser());

                for(Flight flight : flights){
                    Date departureDate = Date.from(flight.getUtcDepartureTime().toInstant());
                    Date arrivalDate = Date.from(flight.getUtcArrivalTime().toInstant());

                    addEvent(new DefaultScheduleEvent(flight.getFlightNumber(), departureDate, arrivalDate, flight));
                }
            }
        };
    }

    public void selectFlight(SelectEvent event) {

        ScheduleEvent scheduleEvent = (ScheduleEvent) event.getObject();
        Flight flight = (Flight) scheduleEvent.getData();

        this.flight = this.flightService.loadFlight(flight.getFlightNumber());

    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}