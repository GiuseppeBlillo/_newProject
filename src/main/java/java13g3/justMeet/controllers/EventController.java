package java13g3.justMeet.controllers;

import java13g3.justMeet.models.Event;
import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value="/event")
public class EventController {
    EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/retrieve")
    public ResponseEntity<?> getAllEvent(){
        return ResponseEntity.ok(
                eventService.retrieveAllEvents());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.retrieveEventById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestParam Event event){
        eventService.createNew(event);
        return ResponseEntity.ok("Aggiunto evento");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable("id") Long id){
        eventService.deleteEventById(id);
        return ResponseEntity.ok("L'evento è stato cancellato");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEventById(
            @PathVariable("id") Long id,
            @RequestBody Event e){
            eventService.updateEvent(id, e);
        return ResponseEntity.ok("Rinnovato evento");
    }
}


