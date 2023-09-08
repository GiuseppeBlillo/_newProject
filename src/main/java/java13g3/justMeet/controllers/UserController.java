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
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<User>> getAllUsers() {
        if (!userService.retrieveAllUsers().isEmpty()){
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
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String userName) {
        if(!userService.retrieveUserByName(userName).isEmpty()){
            return ResponseEntity.ok(userService.retrieveUserByName(userName));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/surname/{surname}")
    public ResponseEntity<List<User>> getUsersBySurname(@PathVariable("surname") String userSurname) {
        if (!userService.retrieveUserBySurname(userSurname).isEmpty()){
            return ResponseEntity.ok(userService.retrieveUserBySurname(userSurname));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/nickname/{nickname}")
    public ResponseEntity<List<User>> getUsersByNickname(@PathVariable("nickname") String userNickname) {
        if (!userService.retrieveUserByNickname(userNickname).isEmpty()){
            return ResponseEntity.ok(userService.retrieveUserByNickname(userNickname));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/age/{age}")
    public ResponseEntity<List<User>> getUsersByAge(@PathVariable("age") int age) {
        if (age >= 0 && age <=100){
            if (!userService.retrieveUserByAge(age).isEmpty()) {
                return ResponseEntity.ok(userService.retrieveUserByAge(age));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieve/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String userEmail) {
        if (userService.retrieveUserByEmail(userEmail).isPresent()) {
            return ResponseEntity.ok(userService.retrieveUserByEmail(userEmail).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/retrieve/phone-number/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        if (userService.retrieveUserByPhoneNumbers(phoneNumber).isPresent()){
            return ResponseEntity.ok(userService.retrieveUserByPhoneNumbers(phoneNumber).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        if (userService.updateUser(id, user).isPresent()){
            return ResponseEntity.ok(userService.updateUser(id, user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserWithId(@PathVariable("id") Long id) {
        if (userService.retrieveUserById(id).isPresent()) {
            userService.deleteUserById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
