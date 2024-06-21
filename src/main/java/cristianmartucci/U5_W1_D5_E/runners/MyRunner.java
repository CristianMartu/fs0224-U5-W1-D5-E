package cristianmartucci.U5_W1_D5_E.runners;

import com.github.javafaker.Faker;
import cristianmartucci.U5_W1_D5_E.entities.Building;
import cristianmartucci.U5_W1_D5_E.entities.Reservation;
import cristianmartucci.U5_W1_D5_E.entities.Station;
import cristianmartucci.U5_W1_D5_E.entities.User;
import cristianmartucci.U5_W1_D5_E.enums.StationType;
import cristianmartucci.U5_W1_D5_E.repositories.StationRepository;
import cristianmartucci.U5_W1_D5_E.repositories.UserRepository;
import cristianmartucci.U5_W1_D5_E.services.BuildingService;
import cristianmartucci.U5_W1_D5_E.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
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
        Faker faker = new Faker(Locale.ITALY);

        Building b1 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName());
        Building b2 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName());
        Building b3 = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().cityName());
        Station s1 = new Station(faker.chuckNorris().fact(), StationType.OPENSPACE, faker.random().nextInt(10,100), b1);
        Station s2 = new Station(faker.chuckNorris().fact(), StationType.MEETINGROOM, faker.random().nextInt(10,100), b2);
        Station s3 = new Station(faker.chuckNorris().fact(), StationType.PRIVATE, faker.random().nextInt(10,100), b3);
        User u1 = new User(faker.gameOfThrones().character(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
        User u2 = new User(faker.gameOfThrones().character(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
        User u3 = new User(faker.gameOfThrones().character(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
        Reservation r1 = new Reservation(s1,u1, LocalDate.now());
        Reservation r2 = new Reservation(s2,u2, LocalDate.now().minusDays(1));
        Reservation r3 = new Reservation(s3,u3, LocalDate.now().minusDays(2));

//        buildingService.save(b1);
//        buildingService.save(b2);
//        buildingService.save(b3);
//        stationRepository.save(s1);
//        stationRepository.save(s2);
//        stationRepository.save(s3);
//        userRepository.save(u1);
//        userRepository.save(u2);
//        userRepository.save(u3);
//        reservationService.save(r1);
//        reservationService.save(r2);
//        reservationService.save(r3);

    }
}
