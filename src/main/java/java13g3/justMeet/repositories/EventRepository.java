package java13g3.justMeet.repositories;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
    Optional<Event> findByCategory(String category);
    Optional<Event> findByEventDate(Date date);
    Optional<Event> findByAddressApi(String addressApi);
    Optional<Event> findByLanguage(LanguageEnum language);
}
