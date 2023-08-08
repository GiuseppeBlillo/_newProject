package classes.models.ClassesDao;

import classes.models.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensioneDao extends JpaRepository<Recensione, Integer>{
}
