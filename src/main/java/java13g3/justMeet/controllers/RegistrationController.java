package java13g3.justMeet.controllers;

import java13g3.justMeet.models.Registration;
import java13g3.justMeet.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        if(registrationService.createRegistration(registration).isPresent()){
            return ResponseEntity.ok(registration);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/retrieve")
    public ResponseEntity<?> registrationList(){
        if (!registrationService.getAllRegistrations().isEmpty()) {
            return ResponseEntity.ok(registrationService.getAllRegistrations());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<?> getRegistrationById(@PathVariable("id") Long registrationId){
        Optional<Registration> regiTemp = registrationService.getRegistrationById(registrationId);
        if (regiTemp.isPresent()) {
            return ResponseEntity.ok(regiTemp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Registration>> updateRegistration(@PathVariable("id") Long id, @RequestBody Registration registrationUp) {
        Optional<Registration> regiTemp = registrationService.getRegistrationById(id);
        if (regiTemp.isPresent()) {
            registrationService.updateRegistration(id,registrationUp);
            return ResponseEntity.ok(regiTemp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Registration>> deleteRegistrationById(@PathVariable("id") Long id) {
        Optional<Registration> regiTemp = registrationService.getRegistrationById(id);
        if (regiTemp.isPresent()) {
            registrationService.deleteRegistration(id);
            return  ResponseEntity.ok(regiTemp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}