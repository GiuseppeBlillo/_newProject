package classes.models.Services;

import classes.models.ClassesDao.PartecipazioneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartecipazioneService {
    private PartecipazioneDao partecipazioneDao;

    @Autowired
    public PartecipazioneService(PartecipazioneDao partecipazioneDao) {
        this.partecipazioneDao = partecipazioneDao;
    }
}
