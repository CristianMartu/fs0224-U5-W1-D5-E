package cristianmartucci.U5_W1_D5_E.services;

import cristianmartucci.U5_W1_D5_E.entities.Building;
import cristianmartucci.U5_W1_D5_E.entities.Reservation;
import cristianmartucci.U5_W1_D5_E.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        if(reservationRepository.existsByStationAndReservation_dateNot(reservation.getStation(), reservation.getReservation_date())){
            reservationRepository.save(reservation);
        }else throw new RuntimeException("Prenotazione non disponibile in " + reservation.getStation().getStation_id() + ", postazione occupata");
    }
}
