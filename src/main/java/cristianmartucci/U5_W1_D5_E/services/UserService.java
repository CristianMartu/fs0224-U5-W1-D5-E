package cristianmartucci.U5_W1_D5_E.services;

import cristianmartucci.U5_W1_D5_E.entities.Building;
import cristianmartucci.U5_W1_D5_E.entities.User;
import cristianmartucci.U5_W1_D5_E.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUserFromDb(String userId) {
        return userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new RuntimeException("Nessun utente trovato con id: " + userId));
    }
}