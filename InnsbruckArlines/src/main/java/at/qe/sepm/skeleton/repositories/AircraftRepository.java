package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AircraftType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for managing {@link Aircraft} entities.
 */

public interface AircraftRepository extends AbstractRepository<Aircraft, String> {

    Aircraft findFirstByAircraftIdentification(String aircraftIdentification);

    List<Aircraft> findByAircraftIdentificationContaining(String aircraftIdentification);

    @Query("SELECT a FROM Aircraft a WHERE :type MEMBER OF a.types")
    List<Aircraft> findByType(@Param("type") AircraftType type);

    @Query("SELECT a FROM Aircraft a WHERE a.location = :location")
    List<Aircraft> findByLocation(@Param("location") String location);
}
