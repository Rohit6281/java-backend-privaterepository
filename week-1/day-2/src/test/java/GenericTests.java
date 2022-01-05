import generics.GenericBox;
import generics.NormalBox;
import opp.Tiger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class GenericTests {
    @DisplayName("test who is parent of all")
    @Test
    void testparentOfAll(){
        Object o1= new String();
        Object o2=new Tiger();
        Object o3=new Date();
        Object o4= Calendar.getInstance();
        Assertions.assertNotNull(01);
        Assertions.assertNotNull(o2);
        Assertions.assertNotNull(03);
        Assertions.assertNotNull(o4);

    }
    @DisplayName("testing normal box")
    @Test
    void testNormalBox(){
        var nb =new NormalBox();
        nb.setContent("this is String");
        var actual=nb.getContent()instanceof String;
        Assertions.assertTrue(actual);
        nb.setContent(new Date());
        actual= nb.getContent() instanceof  Date;
        Assertions.assertTrue(actual);

        nb.setContent(new Tiger());
        actual=nb.getContent() instanceof Tiger;
        Assertions.assertTrue(actual);

    }
    @DisplayName("testing Generic Box - String")
    @Test
    void testGenericBoxString(){
        GenericBox<String> gb1 = new GenericBox<String>();
        gb1.setContent("hello");
        Assertions.assertTrue(gb1.getContent() instanceof  String);
    }
    void testGenericBoxTiger(){
        GenericBox<Tiger>gb2=new GenericBox<Tiger>();
        gb2.setContent(new Tiger());
        Assertions.assertTrue(gb2.getContent()instanceof Tiger);
    }


}
