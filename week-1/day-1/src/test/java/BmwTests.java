import clsobj.Bmw;
import clsobj.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BmwTests {
    @DisplayName(" invalid object")
    @Test
    void testInValidObject(){
        Bmw bmw =null;
        Assertions.assertNull(bmw);
    }
    @DisplayName("valid object")
    @Test
    void testValidObject(){
        Bmw bmw =new Bmw();
        Assertions.assertNotNull(bmw);
        int expectedSpeed=10;
        int actualSpeed=bmw.speed;
        Assertions.assertEquals(expectedSpeed,actualSpeed);
    }
    @DisplayName("test is bmw obj of  car")
    @Test
    void testBmwObjectCar()
    {
        Bmw bmw = new Bmw ();
        boolean expected = true;
        boolean actual =bmw instanceof Car;
        Assertions.assertEquals(expected,actual);
    }
    @DisplayName(" test car is not a Bmw")
    @Test
    void testCarObjectNotBmw()
    {
       Car car = new Car();
       boolean expected = true;
       boolean actual =car instanceof Bmw;
       Assertions.assertEquals(expected,actual);
    }



}
