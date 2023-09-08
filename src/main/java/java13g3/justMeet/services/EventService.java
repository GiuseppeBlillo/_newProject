package java13g3.justMeet.services;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event e) {return eventRepository.save(e);}

    public List<Event> retrieveAllEvents() {return eventRepository.findAll();}

    public Optional<Event> retrieveEventById(Long id) {return eventRepository.findById(id);}

    public List<Event> retrieveEventByName(String eventName){return eventRepository.findByName(eventName);}

    public List<Event> retrieveEventByCategory(String category) {return eventRepository.findByCategory(category);}

    public List<Event> retrieveEventByEventDate(Date date){return eventRepository.findByEventDate(date);}

    public List<Event> retrieveEventByAddressApi(String addressApi) {return eventRepository.findByAddressApi(addressApi);}

    public List<Event> retrieveEventByLanguage(LanguageEnum languageEnum){return eventRepository.findByLanguage(languageEnum);}

    public Optional<Event> updateEvent(Long id, Event currentEvent) {
        Optional<Event> updateEvent = eventRepository.findById(id);
        if (updateEvent.isPresent()){
            updateEvent.get().setName(currentEvent.getName());
            updateEvent.get().setDescription(currentEvent.getDescription());
            updateEvent.get().setCategory(currentEvent.getCategory());
            updateEvent.get().setLanguage(currentEvent.getLanguage());
            updateEvent.get().setCoverPhoto(currentEvent.getCoverPhoto());
            updateEvent.get().setEventDate(currentEvent.getEventDate());
            updateEvent.get().setEventApi(currentEvent.getEventApi());
            updateEvent.get().setAddressApi(currentEvent.getAddressApi());
            updateEvent.get().setPrivate(currentEvent.getPrivate());
            return Optional.of(eventRepository.save(updateEvent.get()));
        } else {
            return Optional.empty();
        }
    }

    public void deleteEventById(Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
        }
    }
}