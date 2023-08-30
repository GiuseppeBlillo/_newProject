package java13g3.justMeet.repositories;

import java13g3.justMeet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNickname(String nickname);
    User findByEmail(String email);
}
