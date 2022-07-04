package com.alexandrazbant.dependencyinjection.services;

import org.springframework.stereotype.Service;


public class SetterGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello - Setter";
    }
}
