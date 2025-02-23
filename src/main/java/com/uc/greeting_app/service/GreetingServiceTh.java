package com.uc.greeting_app.service;


import com.uc.greeting_app.model.Greeting;

import java.util.List;

public interface GreetingServiceTh {
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
    List<Greeting> getAllGreetings();
}

