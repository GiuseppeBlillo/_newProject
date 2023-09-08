package java13g3.justMeet.repositories;

import java13g3.justMeet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    List<User>  findByNickname(String nickname);
    List<User>  findByAge(int age);
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
}
