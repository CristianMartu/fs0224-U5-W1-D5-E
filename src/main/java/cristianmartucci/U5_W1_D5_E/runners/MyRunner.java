package cristianmartucci.U5_W1_D5_E.runners;

import cristianmartucci.U5_W1_D5_E.repositories.StationRepository;
import cristianmartucci.U5_W1_D5_E.repositories.UserRepository;
import cristianmartucci.U5_W1_D5_E.services.BuildingService;
import cristianmartucci.U5_W1_D5_E.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MyRunner implements CommandLineRunner {
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
