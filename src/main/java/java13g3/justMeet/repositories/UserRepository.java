package java13g3.justMeet.repositories;

import java13g3.justMeet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByName(String name);
    Optional<List<User>> findBySurname(String surname);
    Optional<List<User>>  findByPhotoProfile(String photoProfile);
    Optional<List<User>>  findByNickname(String nickname);
    Optional<List<User>>  findByAge(int age);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
