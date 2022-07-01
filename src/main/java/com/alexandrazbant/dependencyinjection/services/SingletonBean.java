package com.alexandrazbant.dependencyinjection.services;

import org.springframework.stereotype.Component;


@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("Creating a Singleton Bean!!!");
    }

    public String getMyScope(){
        return "I'm  a singleton";
    }

}
