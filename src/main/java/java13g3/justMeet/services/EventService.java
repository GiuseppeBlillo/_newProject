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
    private EventRepository eventRepository;

    @Autowired
    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> createEvent(Event e) {
        Optional<Event> optionalEvent = Optional.of(e);
        if (e.getName().isEmpty() || e.getDescription().isEmpty() || e.getCategory().toString().isEmpty()  ||
            e.getLanguage().toString().isEmpty()  || e.getCoverPhoto().isEmpty() || e.getEventDate().toString().isEmpty() ||
            e.getEventApi().isEmpty() || e.getAddressApi().isEmpty() || e.getPrivate().toString().isEmpty() || e.getUserId().isEmpty()){
            return Optional.empty();
        }else {
            eventRepository.save(e);
            return optionalEvent;
        }
    }

    public List<Event> retrieveAllEvents() {
        if(eventRepository.findAll().size() >= 1){
            return eventRepository.findAll();
        }else {
            throw new IllegalArgumentException("Non sono stati trovati eventi");
        }
    }

    public Optional<Event> retrieveEventById(Long id) {
        if (eventRepository.findById(id).isPresent()) {
            return eventRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Event> retrieveEventByName(String eventName) {
        if (eventRepository.findByName(eventName).isPresent()) {
            return eventRepository.findByName(eventName);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> retrieveEventByCategory(String category) {
        if (eventRepository.findByCategory(category).isPresent()) {
            return eventRepository.findByCategory(category);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> retrieveEventByEventDate(Date date) {
        if (eventRepository.findByEventDate(date).isPresent()) {
            return eventRepository.findByEventDate(date);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> retrieveEventByAddressApi(String addressApi) {
        if (eventRepository.findByAddressApi(addressApi).isPresent()) {
            return eventRepository.findByAddressApi(addressApi);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> retrieveEventByLanguage(LanguageEnum languageEnum) {
        if (eventRepository.findByLanguage(languageEnum).isPresent()) {
            return eventRepository.findByLanguage(languageEnum);
        } else {
            return Optional.empty();
        }
    }

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
            eventRepository.save(updateEvent.get());
            return updateEvent;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> deleteEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            eventRepository.deleteById(id);
            return optionalEvent;
        } else {
            return Optional.empty();
        }
    }
}
