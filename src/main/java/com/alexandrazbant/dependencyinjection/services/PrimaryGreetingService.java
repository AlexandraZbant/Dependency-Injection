package com.alexandrazbant.dependencyinjection.services;


public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello - From the PRIMARY BEAN";
    }
}
