package cristianmartucci.U5_W1_D5_E.entities;

import cristianmartucci.U5_W1_D5_E.enums.StationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reservation_id;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    public Reservation(Station station, User user, LocalDate reservation_date) {
        this.station = station;
        this.user = user;
        this.reservationDate = reservation_date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", station=" + station +
                ", user=" + user +
                ", reservation_date=" + reservationDate +
                '}';
    }
}
