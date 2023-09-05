package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable("id") Long id) {
        if(eventService.retrieveEventById(id).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Event>> getEventsByName(@PathVariable("name") String name) {
        if(eventService.retrieveEventByName(name).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventByName(name));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<Optional<Event>> getEventsByCategory(@PathVariable("name") String category) {
        if(eventService.retrieveEventByCategory(category).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventByCategory(category));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Optional<Event>> getEventsByDate(@PathVariable("date") Date date) {
        if(eventService.retrieveEventByEventDate(date).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventByEventDate(date));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/addressApi/{address}")
    public ResponseEntity<Optional<Event>> getEventsByAddressApi(@PathVariable("address") String address) {
        if(eventService.retrieveEventByAddressApi(address).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventByAddressApi(address));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<Optional<Event>> getEventsByLanguage(@PathVariable("id") LanguageEnum language) {
        if(eventService.retrieveEventByLanguage(language).isPresent()){
            return ResponseEntity.ok(eventService.retrieveEventByLanguage(language));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEventById(@PathVariable("id") Long id, @RequestBody Event e) {
        Optional<Event> updateEvent = eventService.updateEvent(id,e);
        if (updateEvent.isPresent()){
            return ResponseEntity.ok("Update dell'evento effettuato con successo!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable("id") Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.ok("L'evento è stato cancellato");
    }
}


