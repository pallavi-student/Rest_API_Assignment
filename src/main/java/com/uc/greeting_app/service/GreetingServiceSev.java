package com.uc.greeting_app.service;


import com.uc.greeting_app.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingServiceSev {
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
    List<Greeting> getAllGreetings();
    Optional<Greeting> getGreetingById(Long id);
    Greeting updateGreeting(Long id, String newMessage);
    void deleteGreeting(Long id);  //  New Method for Deletion
}

