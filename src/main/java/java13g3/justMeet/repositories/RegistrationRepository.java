package java13g3.justMeet.repositories;

import java13g3.justMeet.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
