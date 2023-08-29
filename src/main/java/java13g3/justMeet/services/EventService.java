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

    public Event updateEvent(Event e){
        eventRepository.deleteById(e.getId());
        return eventRepository.save(e);
    }

    public void deleteEvent(Event e){
        eventRepository.delete(e);
    }
}
