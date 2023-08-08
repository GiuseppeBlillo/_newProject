package classes.models.ClassesDao;

import classes.models.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoDao extends JpaRepository<Foto, Integer> {
}
