package com.alexandrazbant.dependencyinjection.configurations;

import com.alexandrazbant.dependencyinjection.services.ConstructorGreetingService;
import com.alexandrazbant.dependencyinjection.services.PropertyGreetingService;
import com.alexandrazbant.dependencyinjection.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService(){
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService(){
        return new SetterGreetingService();
    }
}
