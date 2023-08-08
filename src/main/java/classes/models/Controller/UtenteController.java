package classes.models.Controller;

import classes.models.Services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtenteController {
    private UtenteService serviceUtente;

    @Autowired
    public UtenteController(UtenteService serviceUtente) {
        this.serviceUtente = serviceUtente;
    }

    //Qui dobbiamo mettere i metodi con le chiamate
}
