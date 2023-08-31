package java13g3.justMeet.controllers;

import java13g3.justMeet.models.User;
import java13g3.justMeet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("Utente aggiunto");
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.retrieveUserById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable("id") Long id, @RequestBody User u) {
        userService.updateUser(id, u);
        return ResponseEntity.ok("Utente aggiornato");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("L'utente è stato eliminato");
    }
}
