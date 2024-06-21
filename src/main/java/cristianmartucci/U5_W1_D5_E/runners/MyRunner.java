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
import cristianmartucci.U5_W1_D5_E.services.StationService;
import cristianmartucci.U5_W1_D5_E.services.UserService;
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
    private StationService stationService;

    @Autowired
    private UserService userService;

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

        buildingService.save(b1);
        buildingService.save(b2);
        buildingService.save(b3);
        stationService.save(s1);
        stationService.save(s2);
        stationService.save(s3);
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        reservationService.save(r1);
        reservationService.save(r2);
        reservationService.save(r3);

        System.out.println("____________Prova salvataggio prenotazione con postazione occupata____________");
        try{
            Station stationFromDb = stationService.getStationFromDb("cf5d29f6-17f9-4ad3-ac25-5e6b9998690d");
            User userFromDb = userService.getUserFromDb("b3773746-d528-4138-9567-715ad907ced4");
            Reservation reservation = new Reservation(stationFromDb, userFromDb, LocalDate.now());
            reservationService.save(reservation);
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("____________Prova salvataggio prenotazione in una data con prenotazione già effettuata____________");
        try{
            Station stationFromDb = stationService.getStationFromDb("f2f5d4c6-0942-40b9-a514-70ca14254803");
            User userFromDb = userService.getUserFromDb("f80c72cd-73b0-46aa-acc8-d224ddb8ebe8");
            Reservation reservation = new Reservation(stationFromDb, userFromDb, LocalDate.now());
            reservationService.save(reservation);
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("____________Ricerca postazioni tramite città e stato____________");
        stationService.getStation("Cira nell'emilia", StationType.OPENSPACE).forEach(System.out::println);
    }
}
