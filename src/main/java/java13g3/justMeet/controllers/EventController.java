package java13g3.justMeet.controllers;

import java13g3.justMeet.enumerations.LanguageEnum;
import java13g3.justMeet.models.Event;
import java13g3.justMeet.models.User;
import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }


    @GetMapping("/retrieve")
    public ResponseEntity<List<Event>> getAllEvent() {
        if(!eventService.retrieveAllEvents().isEmpty()){
            return ResponseEntity.ok(eventService.retrieveAllEvents());
        } else {
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

    @GetMapping("/retrieve/name/{name}")
    public ResponseEntity<List<Event>> getEventsByName(@PathVariable("name") String name) {
        if (!eventService.retrieveEventByName(name).isEmpty()) {
            return ResponseEntity.ok(eventService.retrieveEventByName(name));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/category/{category}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable("category") String category) {
        if (!eventService.retrieveEventByCategory(category).isEmpty()) {
            return ResponseEntity.ok(eventService.retrieveEventByCategory(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/date/{date}")
    public ResponseEntity<List<Event>> getEventsByDate(@PathVariable("date") Date date) {
        if (!eventService.retrieveEventByEventDate(date).isEmpty()) {
            return ResponseEntity.ok(eventService.retrieveEventByEventDate(date));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/addressApi/{address}")
    public ResponseEntity<List<Event>> getEventsByAddressApi(@PathVariable("address") String address) {
        if(!eventService.retrieveEventByAddressApi(address).isEmpty()) {
            return ResponseEntity.ok(eventService.retrieveEventByAddressApi(address));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/language/{language}")
    public ResponseEntity<List<Event>> getEventsByLanguage(@PathVariable("language") LanguageEnum language) {
        if(!eventService.retrieveEventByLanguage(language).isEmpty()){
            return ResponseEntity.ok(eventService.retrieveEventByLanguage(language));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Event>> updateEventById(@PathVariable("id") Long id, @RequestBody Event event) {
        if (eventService.updateEvent(id, event).isPresent()) {
            return ResponseEntity.ok(eventService.updateEvent(id, event));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/photo/{id}")
    public ResponseEntity<?> updateEventWithPhoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile multipartFile) {
        if (eventService.updateEventWithPhoto(id, multipartFile).isPresent()){
            return ResponseEntity.ok(eventService.updateEventWithPhoto(id, multipartFile));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/user_list/{id}")
    public ResponseEntity<List<User>> updateEventUsersListById(@PathVariable("id") Long id, @RequestBody User user) {
        if (eventService.updateEventUserList(id, user).isPresent()) {
            return ResponseEntity.ok(eventService.retrieveEventById(id).get().getUserList());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable("id") Long id, @RequestParam Long idUser) {
        try {
            eventService.deleteEventById(id, idUser);
            return ResponseEntity.ok().build();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}