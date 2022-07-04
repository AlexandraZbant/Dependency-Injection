package com.alexandrazbant.dependencyinjection.services;

import com.alexandrazbant.dependencyinjection.repositories.SpanishGreetingRepository;

public class I18nSpanishGreetingService implements GreetingService{

    private final SpanishGreetingRepository spanishGreetingRepository;

    public I18nSpanishGreetingService(SpanishGreetingRepository spanishGreetingRepository) {
        this.spanishGreetingRepository = spanishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return spanishGreetingRepository.getGreeting();
    }
}
