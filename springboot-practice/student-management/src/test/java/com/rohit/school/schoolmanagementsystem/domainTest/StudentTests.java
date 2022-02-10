package com.rohit.school.schoolmanagementsystem.domainTest;

import com.rohit.school.schoolmanagementsystem.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTests {
    @DisplayName("Testing Object Nullability")
    @Test
    void testInValidObject() {
        Student st = null;
        Assertions.assertNull(st);
    }
    @DisplayName("Student Valid Object")
    @Test
    void testBillValidObject() {
        Student st = new Student();
        Assertions.assertNotNull(st);
    }
    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new Student();
        abc.setId(3);
        abc.setName("rohit");
        abc.setLastName("p");
        abc.setEmailId( "rohit.p@gmail.com");
        abc.setUsn("1ks18me425");
        abc.setSem(7);
        abc.getName();

        Assertions.assertEquals(3, abc.getId());
        Assertions.assertEquals("rohit" , abc.getName());
        Assertions.assertEquals("rohit.p@gmail.com",abc.getEmailId());
        Assertions.assertEquals("p",abc.getLastName());
        Assertions.assertEquals(
                ("1ks18me425")
                , abc.getUsn()
        );
    }

}
