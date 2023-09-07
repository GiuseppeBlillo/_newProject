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
        if (!userService.retrieveAllUsers().isEmpty()) {
            return ResponseEntity.ok(userService.retrieveAllUsers());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
//non torna la badRequest
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        if (userService.retrieveUserById(id).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserById(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/name/{name}")
    public ResponseEntity<Optional<List<User>>> getUserByName(@PathVariable("name") String userName) {
        if (userService.retrieveUserByName(userName).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByName(userName));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/surname/{surname}")
    public ResponseEntity<Optional<List<User>>> getUserBySurname(@PathVariable("surname") String userSurname) {
        if (userService.retrieveUserBySurname(userSurname).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserBySurname(userSurname));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/photo/{photo}")
    public ResponseEntity<Optional<List<User>>> getUserByPhoto(@PathVariable("photo") String userPhoto) {
        if (userService.retrieveUserByPhotoProfile(userPhoto).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByPhotoProfile(userPhoto));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/nickname/{nickname}")
    public ResponseEntity<Optional<List<User>>> getUserByNickname(@PathVariable("nickname") String userNickname) {
        if (userService.retrieveUserByNickname(userNickname).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByNickname(userNickname));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/age/{age}")
    public ResponseEntity<Optional<List<User>>> getUserByAge(@PathVariable("age") int age) {
        if (userService.retrieveUserByAge(age).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByAge(age));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable("email") String userEmail) {
        if (userService.retrieveUserByEmail(userEmail).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByEmail(userEmail));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/phonenumber/{phonenumber}")
    public ResponseEntity<Optional<User>> getUserByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) {
        if (userService.retrieveUserByPhoneNumbers(phoneNumber).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByPhoneNumbers(phoneNumber));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        if (userService.updateUser(id, user).isPresent()) {
            return ResponseEntity.ok("Utente aggiornato");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Utente eliminato");
    }
}
