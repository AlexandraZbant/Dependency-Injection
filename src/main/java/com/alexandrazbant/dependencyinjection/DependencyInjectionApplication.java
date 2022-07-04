package com.alexandrazbant.dependencyinjection;

import alexandra.dependencyinjection.pets.controllers.PetController;
import com.alexandrazbant.dependencyinjection.configurations.AlexaConfiguration;
import com.alexandrazbant.dependencyinjection.configurations.AlexaConstructorConfiguration;
import com.alexandrazbant.dependencyinjection.controllers.*;
import com.alexandrazbant.dependencyinjection.datasource.FakeDataSource;
import com.alexandrazbant.dependencyinjection.services.PrototypeBean;
import com.alexandrazbant.dependencyinjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.alexandrazbant.dependencyinjection", "alexandra.dependencyinjection.pets"})
@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

        PetController petController = (PetController) ctx.getBean("petController", PetController.class);
        System.out.println("------ The best pet is");
        System.out.println(petController.whichPetIsTheBest());


        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------ Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("--------------Bean Scope");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("---------------Fake Data Source");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcURL());

        System.out.println("----------------Config Props Bean");
        AlexaConfiguration alexaConfiguration = ctx.getBean(AlexaConfiguration.class);
        System.out.println(alexaConfiguration.getUsername());
        System.out.println(alexaConfiguration.getPassword());
        System.out.println(alexaConfiguration.getJdbcURL());

        System.out.println("---------------Constructor Binding");
        AlexaConstructorConfiguration alexaConstructorConfiguration = ctx.getBean(AlexaConstructorConfiguration.class);
        System.out.println(alexaConstructorConfiguration.getUsername());
        System.out.println(alexaConstructorConfiguration.getPassword());
        System.out.println(alexaConstructorConfiguration.getJdbcURL());
    }
}
