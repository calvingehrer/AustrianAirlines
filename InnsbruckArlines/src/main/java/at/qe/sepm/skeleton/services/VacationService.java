package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.*;
import at.qe.sepm.skeleton.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * Service to create Vacations.
 */

@Component
@Scope("application")
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public Vacation loadVacation(Long vacationId) {
        return vacationRepository.findById(vacationId);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public Collection<Vacation> getVacationOfUser(User user) {
        return vacationRepository.loadVacationOfUser(user);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public void addNewVacation(Vacation vacation) {
        Vacation newVacation = new Vacation();
        newVacation.setVacationId(vacation.getVacationId());
        newVacation.setStartDate(vacation.getStartDate());
        newVacation.setEndDate(vacation.getEndDate());
        newVacation.setUser(vacation.getUser());

        saveVacation(newVacation);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public Vacation saveVacation(Vacation vacation){
        if(vacation.isNew()){
            vacation.setCreateDate(new Date());
        }else{
            vacation.setUpdateDate(new Date());
        }
        return vacationRepository.save(vacation);
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public void deleteVacation(Vacation vacation) {
        vacationRepository.delete(vacation);
    }
}
