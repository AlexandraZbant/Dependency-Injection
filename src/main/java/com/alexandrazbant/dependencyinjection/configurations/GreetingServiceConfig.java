package com.alexandrazbant.dependencyinjection.configurations;

import com.alexandrazbant.dependencyinjection.repositories.EnglishGreetingRepository;
import com.alexandrazbant.dependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.alexandrazbant.dependencyinjection.repositories.SpanishGreetingRepository;
import com.alexandrazbant.dependencyinjection.repositories.SpanishGreetingRepositoryImpl;
import com.alexandrazbant.dependencyinjection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    SpanishGreetingRepository spanishGreetingRepository(){
        return new SpanishGreetingRepositoryImpl();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(SpanishGreetingRepository spanishGreetingRepository){
        return new I18nSpanishGreetingService(spanishGreetingRepository);
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

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
