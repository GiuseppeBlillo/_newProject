package java13g3.justMeet.controllers;

import java13g3.justMeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }
}
