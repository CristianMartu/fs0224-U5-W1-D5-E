package cristianmartucci.U5_W1_D5_E.repositories;

import cristianmartucci.U5_W1_D5_E.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
