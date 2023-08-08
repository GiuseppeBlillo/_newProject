package classes.models.Services;

import classes.models.ClassesDao.RecensioneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecensioneService {
    private RecensioneDao recensioneDao;
    @Autowired
    public RecensioneService(RecensioneDao recensioneDao) {
        this.recensioneDao = recensioneDao;
    }
}
