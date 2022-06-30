package com.alexandrazbant.dependencyinjection.services;

public class I18nSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Ola mundo - ES";
    }
}
