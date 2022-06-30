package com.alexandrazbant.dependencyinjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nService")
public class InEnglishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello Everybody - EN";
    }
}
