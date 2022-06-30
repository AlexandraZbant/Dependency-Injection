package com.alexandrazbant.dependencyinjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"})
@Service("i18nService")
public class InSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Ola mundo - ES";
    }
}
