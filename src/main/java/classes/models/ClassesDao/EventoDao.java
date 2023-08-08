package classes.models.ClassesDao;

import classes.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDao extends JpaRepository<Evento, Integer> {
}
