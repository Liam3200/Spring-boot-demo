package greene.spring.Springboot.demo.controller;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    // @Value("${welcome.message}")
    private String welcomeMessage = "Help! I'm trapped in a Spring Boot application!";

    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }
}
