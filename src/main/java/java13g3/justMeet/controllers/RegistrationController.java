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
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        return ResponseEntity.ok(registrationService.createRegistration(registration));
    }
    @GetMapping("/retrieve")
    public ResponseEntity<List<Registration>> registrationList(){
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<Registration>> getRegistrationById(@PathVariable("id") Long registrationId){
        if (registrationService.getRegistrationById(registrationId).isPresent()) {
            return ResponseEntity.ok(registrationService.getRegistrationById(registrationId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRegistration(@PathVariable("id") Long id, @RequestBody Registration registrationUp) {
        if (registrationService.updateRegistration(id, registrationUp).isPresent()){
            return ResponseEntity.ok(registrationService.updateRegistration(id, registrationUp));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegistrationById(@PathVariable("id") Long id) {
        if (registrationService.getRegistrationById(id).isPresent()) {
            registrationService.deleteRegistration(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}