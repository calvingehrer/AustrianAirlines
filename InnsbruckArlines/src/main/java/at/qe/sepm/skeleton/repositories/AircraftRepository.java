package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AircraftType;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Repository for managing {@link Aircraft} entities.
 */

public interface AircraftRepository extends AbstractRepository<Aircraft, String> {

    Aircraft findFirstByAircraftIdentification(String aircraftIdentification);

    List<Aircraft> findByAircraftIdentificationContaining(String aircraftIdentification);

    @Query("SELECT a FROM Aircraft a WHERE :type MEMBER OF a.types")
    List<Aircraft> findByType(@Param("type") AircraftType type);

    @Query("SELECT a FROM Aircraft a WHERE a.location = :location AND a.available = true")
    List<Aircraft> findByLocation(@Param("location") String location);

    @Query("SELECT a FROM Aircraft a WHERE :type = a.aircraftType")
    List<Aircraft> findAircraftByType(@Param("type") AircraftType type);

    @Query("SELECT a FROM Aircraft a WHERE a.aircraftIdentification LIKE CONCAT(:aircraftIdPrefix, '%')")
    List<Aircraft> findAircraftByIdPrefix(@Param("aircraftIdPrefix") String aircraftIdPrefix);

    @Query("SELECT a FROM Aircraft a left join Flight f ON a.aircraftIdentification = f.usedAircraft.aircraftIdentification WHERE a.location = :location AND (f.utcArrivalTime < :date OR f.flightNumber = null)")
    List<Aircraft> findByLocationAndDate(@Param("location") String location, @Param("date") Date date);

}
