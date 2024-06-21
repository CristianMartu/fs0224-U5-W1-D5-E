package cristianmartucci.U5_W1_D5_E.repositories;

import cristianmartucci.U5_W1_D5_E.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
