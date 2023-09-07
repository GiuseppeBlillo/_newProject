package java13g3.justMeet.services;

import java13g3.justMeet.models.Registration;
import java13g3.justMeet.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    RegistrationRepository registrationRepository;
    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void createRegistration(Registration r) throws Exception {
        if(!r.getUserList().isEmpty() || !r.getDateTime().isAfter(LocalDateTime.now())) {
            registrationRepository.save(r);
        } else {
            throw new Exception();
        }
    }
    public Optional<Registration> getRegistrationById(Long RegistrationId){
        Optional<Registration> regiTemp = registrationRepository.findById(RegistrationId);
        if(regiTemp.isPresent()){
            return regiTemp;
        } else {
            return Optional.empty();
        }
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
    public Optional<Object> deleteRegistration(Long id){
        Optional<Registration> regiTemp = registrationRepository.findById(id);
        if (regiTemp.isPresent()) {
            registrationRepository.deleteById(id);
            return Optional.of(regiTemp);
        } else {
            return Optional.empty();
        }
    }
}