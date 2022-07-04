package com.alexandrazbant.dependencyinjection.services;

import org.springframework.stereotype.Service;


public class PropertyGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello - Property";
    }
}
