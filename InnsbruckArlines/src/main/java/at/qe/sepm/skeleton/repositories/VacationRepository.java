package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import java.util.List;

import at.qe.sepm.skeleton.model.Vacation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for managing {@link Vacation} entities.
 *
 */
public interface VacationRepository extends AbstractRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation v WHERE v.user = :user")
    List<Vacation> loadVacationOfUser(@Param("user") User user);
}
