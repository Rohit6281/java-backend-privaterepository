import factory.Atm;
import factory.CardProvider;
import org.junit.jupiter.api.Assertions;

public class AtmTests {
    void testAtmSwipe(){
        Atm atm =new Atm();
        CardProvider provider=atm.swipe("pqr");
        Assertions.assertEquals("pqr",provider.getBank());

    }
}
