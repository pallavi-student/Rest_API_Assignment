package com.uc.greeting_app.controller;


import com.uc.greeting_app.service.GreetingServiceTwo;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting_Two")
public class GreetingControllerTwo {

    private final GreetingServiceTwo greetingService;

    public GreetingControllerTwo(GreetingServiceTwo greetingService) {
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
}

