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
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration createRegistration(Registration r) {
        return registrationRepository.save(r);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(Long RegistrationId) {
        return registrationRepository.findById(RegistrationId);
    }

    public Optional<Registration> updateRegistration(Long id, Registration currentRegistration) {
        Optional<Registration> updateRegistration = registrationRepository.findById(id);
        if (updateRegistration.isPresent()) {
            updateRegistration.get().setDateTime(currentRegistration.getDateTime());
            registrationRepository.save(updateRegistration.get());
            return Optional.of(registrationRepository.save(updateRegistration.get()));
        } else {
            return Optional.empty();
        }
    }

    public void deleteRegistration(Long id) {
        if (registrationRepository.findById(id).isPresent()) {
            registrationRepository.deleteById(id);
        }
    }
}