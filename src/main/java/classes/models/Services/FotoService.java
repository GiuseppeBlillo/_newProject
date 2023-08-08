package classes.models.Services;

import classes.models.ClassesDao.FotoDao;
import classes.models.Foto;
import classes.models.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {
    private FotoDao fotoDao;

    @Autowired
    public FotoService(FotoDao fotoDao) {
        this.fotoDao = fotoDao;
    }

    public void insertFoto(){

        List<Foto> testRecensione = null;
        Recensione recensione= new Recensione(1,1,1,"Bella foto",5,testRecensione);
        fotoDao.save(new Foto(1,"Url",recensione));
    }
}
