package java13g3.justMeet.controllers;

import java13g3.justMeet.models.User;
import java13g3.justMeet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
class UserController {
    private final UserService userService;

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
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.retrieveUserById(id));
    }
    @GetMapping("/retrieve/name/{name}")
    public ResponseEntity<Optional<List<User>>> getUserByName(@PathVariable("name") String userName) {
        return ResponseEntity.ok(userService.retrieveUserByName(userName));
    }
    @GetMapping("/retrieve/surname/{surname}")
    public ResponseEntity<Optional<List<User>>> getUserBySurname(@PathVariable("surname") String userSurname) {
        return ResponseEntity.ok(userService.retrieveUserBySurname(userSurname));
    }
    @GetMapping("/retrieve/photo/{photo}")
    public ResponseEntity<Optional<List<User>>> getUserByPhoto(@PathVariable("photo") String userPhoto) {
        return ResponseEntity.ok(userService.retrieveUserByPhotoProfile(userPhoto));
    }
    @GetMapping("/retrieve/nickname/{nickname}")
    public ResponseEntity<Optional<List<User>>> getUserByNickname(@PathVariable("nickname") String userNickname) {
        return ResponseEntity.ok(userService.retrieveUserByNickname(userNickname));
    }
    @GetMapping("/retrieve/age/{age}")
    public ResponseEntity<Optional<List<User>>> getUserByAge(@PathVariable("age") int age) {
        return ResponseEntity.ok(userService.retrieveUserByAge(age));
    }
    @GetMapping("/retrieve/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable("email") String userEmail) {
        return ResponseEntity.ok(userService.retrieveUserByEmail(userEmail));
    }
    @GetMapping("/retrieve/phonenumber/{phonenumber}")
    public ResponseEntity<Optional<User>> getUserByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) {
        return ResponseEntity.ok(userService.retrieveUserByPhoneNumbers(phoneNumber));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok("Utente aggiornato");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Utente eliminato");
    }
}
