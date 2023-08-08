package classes.models.ClassesDao;

import classes.models.Partecipazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartecipazioneDao extends JpaRepository<Partecipazione,Integer> {
}
