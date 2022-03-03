package com.JDBCApi.crudJDBCTemplate.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTests {
    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new User();
        abc.setId(1);
        abc.setName("rohit");
        abc.setLastName("p");
        abc.setEmail("rohit@gmail.com");

        Assertions.assertEquals(1, abc.getId());
        Assertions.assertEquals("rohit" , abc.getName());
        Assertions.assertEquals("p",abc.getLastName());
        Assertions.assertEquals(
                ("rohit@gmail.com")
                , abc.getEmail()
        );
    }
    @DisplayName("Testing Object Nullability")
    @Test
    void testInValidObject() {
        User us = null;
        Assertions.assertNull(us);
    }
    @DisplayName("User Valid Object")
    @Test
    void testValidObject() {
        User us = new User();
        Assertions.assertNotNull(us);
    }
}
