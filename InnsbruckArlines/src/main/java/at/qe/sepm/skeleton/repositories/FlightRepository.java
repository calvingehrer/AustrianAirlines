package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;;

import java.util.List;

/**
 * Repository for managing {@link Flight} entities.
 */

public interface FlightRepository extends AbstractRepository<Flight, String> {

    Flight findFirstByFlightNumber(String flightNumber);

    @Query("SELECT f FROM Flight f WHERE f.usedAircraft.aircraftIdentification = :aircraftId")
    List<Flight> findByUsedAircraft(@Param("aircraftId") String aircraftId);
}
