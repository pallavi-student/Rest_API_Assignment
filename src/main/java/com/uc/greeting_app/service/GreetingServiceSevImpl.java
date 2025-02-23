package com.uc.greeting_app.service;


import com.uc.greeting_app.model.Greeting;
import com.uc.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServiceSevImpl implements GreetingServiceSev {

    private final GreetingRepository greetingRepository;

    public GreetingServiceSevImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getGreetingMessage(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save the message to the database
        saveGreeting(message);
        return message;
    }

    @Override
    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

    @Override
    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);  //  Deleting from Database
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }
}

