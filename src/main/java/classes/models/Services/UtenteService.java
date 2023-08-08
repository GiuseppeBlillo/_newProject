package classes.models.Services;

import classes.models.ClassesDao.UtenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    private UtenteDao utenteDao;
    @Autowired
    public UtenteService(UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }
}
