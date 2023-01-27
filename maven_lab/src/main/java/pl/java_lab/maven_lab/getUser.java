package pl.java_lab.maven_lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getUser {
    @GetMapping("/name")
    public String getName() {
        return "Kajetan";
    }

    @GetMapping("/surname")
    public String getSurname() {
        return "Warmbier";
    }
}
