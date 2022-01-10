package Rohit.config;

import Rohit.Driver.Driver;
import Rohit.car.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("Rohit")
@Configuration
public class AppConf {
//    @Bean
//     public Car car(){
//        return new Car();
//
//     }
     @Bean
     public Driver dri(){
        return new Driver();

     }
}
