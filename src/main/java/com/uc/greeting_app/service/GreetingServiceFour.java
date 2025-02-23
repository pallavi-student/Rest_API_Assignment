package com.uc.greeting_app.service;


import com.uc.greeting_app.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface GreetingServiceFour {
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
    List<Greeting> getAllGreetings();
    Optional<Greeting> getGreetingById(Long id);  // ✅ New Method
}

