import opp.Animal;
import opp.Tiger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTests {
    @Test
    void testAnimalObject() {


        Animal animal = new Tiger();
        Assertions.assertNotNull(animal);
    }
    @Test
    void testTigerWalking(){
        var tiger =new Tiger();
        var expected ="tiger is walking";
        var actual =tiger.walk();
        Assertions.assertEquals(expected,actual);

    }
    @Test
    void testTigerLocation(){
        var tiger=new Tiger();
        var expected =true;
        var actual = tiger.checkLocation();
        Assertions.assertEquals(expected,actual);
    }

}

