package com.uc.greeting_app.controller;


import com.uc.greeting_app.model.Greeting;
import com.uc.greeting_app.service.GreetingServiceTh;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting_Th")
public class GreetingControllerTh {

    private final GreetingServiceTh greetingService;

    public GreetingControllerTh(GreetingServiceTh greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message = greetingService.getGreetingMessage(firstName, lastName);

        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}

