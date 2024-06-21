package cristianmartucci.U5_W1_D5_E.repositories;

import cristianmartucci.U5_W1_D5_E.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
}
