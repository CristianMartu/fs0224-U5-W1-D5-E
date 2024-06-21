package cristianmartucci.U5_W1_D5_E.entities;

import cristianmartucci.U5_W1_D5_E.enums.StationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "stations")
@NoArgsConstructor
@Getter
@Setter
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID station_id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    private int max_number_user;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Station(String description, StationType stationType, int max_number_user, Building building) {
        this.description = description;
        this.stationType = stationType;
        this.max_number_user = max_number_user;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Station{" +
                "station_id=" + station_id +
                ", description='" + description + '\'' +
                ", stationType=" + stationType +
                ", max_number_user=" + max_number_user +
                ", building=" + building +
                '}';
    }
}