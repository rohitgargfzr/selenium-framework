package com.incompetent.tester.automation.selenium.ide;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @PostMapping("/")
    public String seleniumTest(@RequestBody String jsonBody){
        return "Selenium IDE";
    }
}
