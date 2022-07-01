package com.alexandrazbant.dependencyinjection.repositories;

public class SpanishGreetingRepositoryImpl implements SpanishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Ola";
    }
}
