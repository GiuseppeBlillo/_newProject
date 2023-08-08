package classes.models.Controller;

import classes.models.Services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FotoController {
    private FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping(value="/insert/foto")
    public ResponseEntity<?> insertFoto(){
        fotoService.insertFoto();
        return ResponseEntity.ok().build();
    }
}
