package classes.models.Services;

import classes.models.ClassesDao.FotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {
    private FotoDao fotoDao;

    @Autowired
    public FotoService(FotoDao fotoDao) {
        this.fotoDao = fotoDao;
    }
}
