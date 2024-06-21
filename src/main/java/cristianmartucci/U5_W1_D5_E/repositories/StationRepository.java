package cristianmartucci.U5_W1_D5_E.repositories;

import cristianmartucci.U5_W1_D5_E.entities.Station;
import cristianmartucci.U5_W1_D5_E.enums.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {

    @Query("SELECT s FROM Station s WHERE s.building.city ILIKE :city AND s.stationType = :type")
    List<Station> filterByCityAndStationType(String city, StationType type);
}
