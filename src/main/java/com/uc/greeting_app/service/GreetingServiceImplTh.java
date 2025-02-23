package com.uc.greeting_app.service;

import com.uc.greeting_app.model.Greeting;
import com.uc.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImplTh implements GreetingServiceTh {

    private final GreetingRepository greetingRepository;

    public GreetingServiceImplTh(GreetingRepository greetingRepository) {
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

        // Save the greeting message to the database
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
}

