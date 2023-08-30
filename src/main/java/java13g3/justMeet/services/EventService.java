package java13g3.justMeet.services;

import java13g3.justMeet.models.Event;
import java13g3.justMeet.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    EventRepository eventRepository;

    @Autowired
    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Event createNew(Event e){
        if(e != null){
            return eventRepository.save(e);
        } return null;
    }

    public List<Event> retrieveAllEvents(){
        return eventRepository.findAll();
    }

    public Event retrieveEventById(Long id){
        return eventRepository.getReferenceById(id);
    }

    public Event updateEvent(Long id,Event e){
        eventRepository.deleteById(id);
        return eventRepository.save(e);
    }

    public void deleteEventById(Long id){
        eventRepository.deleteById(id);
    }
}
