package cristianmartucci.U5_W1_D5_E.services;

import cristianmartucci.U5_W1_D5_E.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;
}
