package com.alexandrazbant.dependencyinjection.configurations;


import alexandra.dependencyinjection.pets.services.PetService;
import alexandra.dependencyinjection.pets.services.PetServiceFactory;
import com.alexandrazbant.dependencyinjection.repositories.*;
import com.alexandrazbant.dependencyinjection.services.*;
import org.springframework.context.annotation.*;

@Configuration
public class GreetingServiceConfig {


    @Bean
    PetServiceFactory petServiceFactory(){
       return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

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
