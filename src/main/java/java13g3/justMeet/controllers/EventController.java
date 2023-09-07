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
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        if(eventService.createEvent(event).isPresent()) {
            return ResponseEntity.ok(event);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Event>> getAllEvent() {
        if( eventService.retrieveAllEvents().size() >=1){
            return ResponseEntity.ok(eventService.retrieveAllEvents());
        }else {
            return ResponseEntity.notFound().build();
        }
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
    public ResponseEntity<Optional<Event>> updateEventById(@PathVariable("id") Long id, @RequestBody Event event) {
        Optional<Event> updateEvent = eventService.updateEvent(id,event);
        if (updateEvent.isPresent()){
            eventService.updateEvent(id,event);
            return ResponseEntity.ok(updateEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Event>> deleteEventById(@PathVariable("id") Long id) {
        Optional<Event> optionalEvent = eventService.deleteEventById(id);
        if(optionalEvent.isPresent()){
           eventService.deleteEventById(id);
           return ResponseEntity.ok(optionalEvent);
        };
           return ResponseEntity.notFound().build();
    }
}


