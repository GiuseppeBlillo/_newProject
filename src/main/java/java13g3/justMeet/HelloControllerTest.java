package java13g3.justMeet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerTest {

    @GetMapping("/hello")
    public ResponseEntity<String> helloTest(){
        return ResponseEntity.ok("Hello, this is a test");
    }
}
