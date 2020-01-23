package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.Vacation;
import at.qe.sepm.skeleton.services.VacationService;
import at.qe.sepm.skeleton.ui.beans.SessionInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.*;

@Component
@Scope("view")
public class VacationController implements Serializable {


    @Autowired
    private VacationService vacationService;
    @Autowired
    private SessionInfoBean sessionInfoBean;

    private Vacation vacation;
    private User user;
    private List<Vacation> vacations;

    @PostConstruct
    public void init(){
        user = sessionInfoBean.getCurrentUser();
        new ArrayList<>(this.vacationService.getVacationOfUser(user));
    }

    public void add() {
        vacation.setUser(this.user);
        this.vacationService.addNewVacation(vacation);
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

}