package java13g3.justMeet.controllers;

import java13g3.justMeet.models.Registration;
import java13g3.justMeet.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<String> createRegistration(@RequestBody Registration registration){
        registrationService.createRegistration(registration);
        return ResponseEntity.ok("Registration added!");
    }

    @GetMapping("retrieve")
    public ResponseEntity<List<Registration>> registrationList(){
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable("id") Long registrationId){
        return ResponseEntity.ok(registrationService.getRegistrationById(registrationId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRegistration(@PathVariable("id") Long id, @RequestBody Registration registrationUp){
        Optional<Registration> tempReg = registrationService.updateRegistration(id,registrationUp);
        if (tempReg.isPresent()) {
            return ResponseEntity.ok("Update della recensione effettuato con succeso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRegistrationById(@PathVariable("id") Long id){
        registrationService.deleteRegistration(id);
        return  ResponseEntity.ok("Registrazione eliminata!");
    }
}
