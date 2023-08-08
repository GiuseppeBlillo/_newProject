package classes.models.Controller;

import classes.models.Services.PartecipazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartecipazioneController {
    private PartecipazioneService partecipazioneService;

    @Autowired
    public PartecipazioneController(PartecipazioneService partecipazioneService) {
        this.partecipazioneService = partecipazioneService;
    }
}
