import Rohit.Driver.Driver;
import Rohit.car.Bwm;
import Rohit.car.Car;
import Rohit.config.AppConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        // hey spring - i have written beans configuration in AppConfig class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

        Car car1 = (Car)  context.getBean("car");
        car1.speedUp();

        Bwm bm=context.getBean(Bwm.class);

        Driver driver1 = (Driver) context.getBean("dri");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
