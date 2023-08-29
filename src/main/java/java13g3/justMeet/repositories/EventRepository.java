package java13g3.justMeet.repositories;

import java13g3.justMeet.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
