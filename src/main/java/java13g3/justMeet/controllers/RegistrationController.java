package java13g3.justMeet.controllers;

import java13g3.justMeet.models.Registration;
import java13g3.justMeet.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registration")
class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRegistration(@RequestBody Registration registration) {
        try {
            registrationService.createRegistration(registration);
            return ResponseEntity.ok("Registrazione aggiunta!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Registrazione non aggiunta, controlla tutti i campi!");
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<?> registrationList(){
        if (!registrationService.getAllRegistrations().isEmpty()) {
            return ResponseEntity.ok(registrationService.getAllRegistrations());
        } else {
            return ResponseEntity.badRequest().body("Non sono presenti registrazioni!");
        }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<?> getRegistrationById(@PathVariable("id") Long registrationId){
        try {
            return ResponseEntity.ok(registrationService.getRegistrationById(registrationId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Non esiste una registrazione con questo ID");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRegistration(@PathVariable("id") Long id, @RequestBody Registration registrationUp) throws Exception {
        Optional<Registration> regiTemp = registrationService.getRegistrationById(id);
        if (regiTemp.isPresent()) {
            registrationService.updateRegistration(id,registrationUp);
            return ResponseEntity.ok("Update della recensione effettuato con successo!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Non esiste una registrazione con questo ID, pertanto non è stato possibile modificarla");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRegistrationById(@PathVariable("id") Long id){
        try {
            registrationService.deleteRegistration(id);
            return  ResponseEntity.ok("Registrazione eliminata!");
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Non esiste alcuna registrazione con questo ID");
        }
    }
}
