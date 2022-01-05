import exception.BadNumberException;
import exception.NumDivider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumDividerTests {
    @DisplayName("test for complete numbers")
    @Test
    void testCompleteNumbers(){
        var dvDr=new NumDivider();
        var num1=10;
        var num2=10;
        var expected=1;
        var actual =dvDr.divideNumbers(num1,num2);
        Assertions.assertEquals(expected,actual);

    }
    @DisplayName("Test for complete numbers")
    @Test
    void testPrecissionNumbers(){
        var dvDr=new NumDivider();
        var num1=4.2;
        var num2=2.2;
        var expected =1.9090;
        var actual = dvDr.divideNumbers(num1, num2);
        Assertions.assertEquals(expected,actual);
    }
    @DisplayName("test for Unexpected numbers")
    @Test
   void testUnexpectedNumbers(){
        var num1=4.5;
        var num2=0;
        var dvDr= new NumDivider();
        var expected =0;
        var actual =dvDr.divideNumbers(num1,num2);
        Assertions.assertEquals(expected, actual);
   }
   void testUnexpectednumberWithException(){
        var num1=4.5;
        var num2=0;
        var ex =Assertions.assertThrows(BadNumberException.class,()->{
            var dvDr=new NumDivider();
            dvDr.divideNumbersException(num1,num2);
        });
        var expected ="num2 is 0";
        var actual =ex.getMessage();
        Assertions.assertEquals(expected,actual);
   }
}
