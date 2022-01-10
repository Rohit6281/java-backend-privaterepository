package Rohit.car;

import Rohit.tempo.tempo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private tempo tem;

    public void speedUp(){
        System.out.println("speeding up the car");
    }

}
