package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return ResponseEntity.ok("Aggiunto evento");
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Event>> getAllEvent() {
        return ResponseEntity.ok(
                eventService.retrieveAllEvents());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventService.retrieveEventById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Event>> getEventsByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(eventService.retrieveEventByName(name));
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable("name") String category) {
        return ResponseEntity.ok(eventService.retrieveEventByCategory(category));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> getEventsByDate(@PathVariable("date") Date date) {
        return ResponseEntity.ok(eventService.retrieveEventByEventDate(date));
    }

    @GetMapping("/addressApi/{address}")
    public ResponseEntity<List<Event>> getEventsByAddressApi(@PathVariable("address") String address) {
        return ResponseEntity.ok(eventService.retrieveEventByAddressApi(address));
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<List<Event>> getEventsByLanguage(@PathVariable("id") LanguageEnum language) {
        return ResponseEntity.ok(eventService.retrieveEventByLanguage(language));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEventById(@PathVariable("id") Long id, @RequestBody Event e) {
        eventService.updateEvent(id, e);
        return ResponseEntity.ok("Rinnovato evento");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable("id") Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.ok("L'evento è stato cancellato");
    }


}


