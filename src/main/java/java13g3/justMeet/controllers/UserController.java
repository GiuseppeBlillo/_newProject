package java13g3.justMeet.controllers;

import java13g3.justMeet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {
    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
}
