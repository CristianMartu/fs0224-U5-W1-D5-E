package cristianmartucci.U5_W1_D5_E.services;

import cristianmartucci.U5_W1_D5_E.entities.Building;
import cristianmartucci.U5_W1_D5_E.entities.Station;
import cristianmartucci.U5_W1_D5_E.entities.User;
import cristianmartucci.U5_W1_D5_E.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public void save(Station station) {
        stationRepository.save(station);
    }

    public Station getStationFromDb(String stationId) {
        return stationRepository.findById(UUID.fromString(stationId)).orElseThrow(() -> new RuntimeException("Nessuna postazione trovata con id: " + stationId));
    }
}
