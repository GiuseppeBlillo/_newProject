package classes.models.Services;

import classes.models.ClassesDao.EventoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    private EventoDao eventoDao;

    @Autowired
    public EventoService(EventoDao eventoDao) {
        this.eventoDao = eventoDao;
    }
}
