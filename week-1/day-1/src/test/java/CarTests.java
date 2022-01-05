import clsobj.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTests
{
       @DisplayName("car invalid object")
       @Test
       void testInvalidObject()
       {
           Car car = null;
           Assertions.assertNull(car);
       }
       @DisplayName("car valid object")
       @Test
       void testCarValidObject()
       {
           Car car= new Car();
           Assertions.assertNotNull(car);

       }
       @DisplayName("car by default constructor")
       @Test
       void testCarSpeedDefault()
       {
           Car car= new Car(100);
           int expectedSpeed =10;
           int actualSpeed = car.speed;
           Assertions.assertEquals(expectedSpeed, actualSpeed);

       }
       @DisplayName("car by parameterized constructor")
       @Test
       void testSpeedParameterized(){
           Car car =new Car(100);
           int exceptedSpeed=100;
           int actualSpeed= car.speed;
           Assertions.assertEquals(exceptedSpeed, actualSpeed);
       }
    @DisplayName("Check Car Speed ")
    @Test
    void testSpeedUp() {
        Car car = new Car(); // here speed is 10
        car.speedUp(); // speed = speed + 10 = 10 + 10 = 20

        int expectedSpeed = 20;
        int actualSpeed = car.speed;

        Assertions.assertEquals(expectedSpeed, actualSpeed);
    }

    @DisplayName("Check Speed if it negative")
    @Test
    void testSpeedUpNegative() {
        Car car = new Car(-100);
        car.speedUp();

        int expectedSpeed = -90;
        int actualSpeed = car.speed;
        Assertions.assertEquals(expectedSpeed, actualSpeed);
    }



   }

