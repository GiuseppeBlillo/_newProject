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
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.createUser(user).isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/retrieve")
    public ResponseEntity<List<User>> getAllUsers() {
        if (!userService.retrieveAllUsers().isEmpty()) {
            return ResponseEntity.ok(userService.retrieveAllUsers());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        if (userService.retrieveUserById(id).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/name/{name}")
    public ResponseEntity<Optional<List<User>>> getUserByName(@PathVariable("name") String userName) {
        if (userService.retrieveUserByName(userName).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByName(userName));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/surname/{surname}")
    public ResponseEntity<Optional<List<User>>> getUserBySurname(@PathVariable("surname") String userSurname) {
        if (userService.retrieveUserBySurname(userSurname).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserBySurname(userSurname));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/photo/{photo}")
    public ResponseEntity<Optional<List<User>>> getUserByPhoto(@PathVariable("photo") String userPhoto) {
        if (userService.retrieveUserByPhotoProfile(userPhoto).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByPhotoProfile(userPhoto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/nickname/{nickname}")
    public ResponseEntity<Optional<List<User>>> getUserByNickname(@PathVariable("nickname") String userNickname) {
        if (userService.retrieveUserByNickname(userNickname).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByNickname(userNickname));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/age/{age}")
    public ResponseEntity<Optional<List<User>>> getUserByAge(@PathVariable("age") int age) {
        if (userService.retrieveUserByAge(age).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByAge(age));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable("email") String userEmail) {
        if (userService.retrieveUserByEmail(userEmail).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByEmail(userEmail));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/phonenumber/{phonenumber}")
    public ResponseEntity<Optional<User>> getUserByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) {
        if (userService.retrieveUserByPhoneNumbers(phoneNumber).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByPhoneNumbers(phoneNumber));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<User>> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> userTemp = userService.retrieveUserById(id);
        if (userTemp.isPresent()) {
            userService.updateUser(id, user);
            return ResponseEntity.ok(userTemp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<User>> deleteUserById(@PathVariable("id") Long id) {
        Optional<User> userTemp = userService.retrieveUserById(id);
        if(userTemp.isPresent()){
            userService.deleteUserById(id);
            return ResponseEntity.ok(userTemp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
