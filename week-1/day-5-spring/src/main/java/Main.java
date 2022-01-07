import Car.Car;
import Car.Driver;

public class Main {
    public static void main (String[] args){
        Car car=new Car();
        Driver driver =new Driver();
        driver.setCar(car);
    }
}
