package java13g3.justMeet.controllers;

import java13g3.justMeet.models.Event;
import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event){
        if(event == null){
            return ResponseEntity.badRequest().body("Invalid event's fields!");
        } else eventService.createNew(event);
        return ResponseEntity.ok("Event created!");
    }
}
