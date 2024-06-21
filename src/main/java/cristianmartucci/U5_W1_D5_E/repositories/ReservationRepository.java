package cristianmartucci.U5_W1_D5_E.repositories;

import cristianmartucci.U5_W1_D5_E.entities.Reservation;
import cristianmartucci.U5_W1_D5_E.entities.Station;
import cristianmartucci.U5_W1_D5_E.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    boolean existsByStationAndReservationDate(Station station, LocalDate date);

    boolean existsByUserAndReservationDate(User user, LocalDate date);
}
