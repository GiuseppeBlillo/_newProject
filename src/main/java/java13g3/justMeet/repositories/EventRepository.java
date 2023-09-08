package java13g3.justMeet.repositories;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String name);
    List<Event> findByCategory(String category);
    List<Event> findByEventDate(Date date);
    List<Event> findByAddressApi(String addressApi);
    List<Event> findByLanguage(LanguageEnum language);
}
