package com.uc.greeting_app.controller;


import com.uc.greeting_app.model.Greeting;
import com.uc.greeting_app.service.GreetingServiceSev;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/greeting_7")
public class GreetingControllerSev {

    private final GreetingServiceSev greetingService;

    public GreetingControllerSev(GreetingServiceSev greetingService) {
        this.greetingService = greetingService;
    }

    // Generate and Save Greeting
    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message = greetingService.getGreetingMessage(firstName, lastName);

        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

    // Fetch All Saved Greetings
    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

    // Fetch Greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.getGreetingById(id);
        if (greeting.isPresent()) {
            return ResponseEntity.ok(greeting.get());
        } else {
            return ResponseEntity.status(404).body("Greeting Not Found!");
        }
    }

    // Update Greeting by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String newMessage = request.get("message");
            Greeting updatedGreeting = greetingService.updateGreeting(id, newMessage);
            return ResponseEntity.ok(updatedGreeting);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    //  Delete Greeting by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGreeting(@PathVariable Long id) {
        try {
            greetingService.deleteGreeting(id);
            return ResponseEntity.ok("Greeting deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}

