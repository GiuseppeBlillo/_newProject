package java13g3.justMeet.services;

import java13g3.justMeet.models.Registration;
import java13g3.justMeet.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    RegistrationRepository registrationRepository;
    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void createRegistration(Registration r){
        if(r!=null) {
            registrationRepository.save(r);
        }
    }
    public Registration getRegistrationById(Long RegistrationId){
        return registrationRepository.findById(RegistrationId).orElse(null);
    }
    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll();
    }
    public Optional<Registration> updateRegistration(Long id, Registration currentRegistration) {
        Optional<Registration> updateRegistration = registrationRepository.findById(id);
        if (updateRegistration.isPresent()){
            updateRegistration.get().setDateTime(currentRegistration.getDateTime());
            registrationRepository.save(updateRegistration.get());
            return updateRegistration;
        } else {
            return Optional.empty();
        }
    }
    public void deleteRegistration(Long id){
        registrationRepository.deleteById(id);
    }
}