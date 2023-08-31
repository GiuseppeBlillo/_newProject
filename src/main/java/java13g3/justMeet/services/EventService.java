package java13g3.justMeet.services;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    EventRepository eventRepository;

    @Autowired
    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(Event e) {
        if (e != null) {
            eventRepository.save(e);
        }
    }

    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    public Event retrieveEventById(Long id) {
        return eventRepository.getReferenceById(id);
    }

    public List<Event> retrieveEventByName(String eventName) {
        return eventRepository.findByName(eventName);
    }

    public List<Event> retrieveEventByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> retrieveEventByEventDate(Date date) {
        return eventRepository.findByEventDate(date);
    }

    public List<Event> retrieveEventByAddressApi(String addressApi) {
        return eventRepository.findByAddressApi(addressApi);
    }

    public List<Event> retrieveEventByLanguage(LanguageEnum languageEnum) {
        return eventRepository.findByLanguage(languageEnum);
    }

    public void updateEvent(Long id, Event e) {
        eventRepository.deleteById(id);
        eventRepository.save(e);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
