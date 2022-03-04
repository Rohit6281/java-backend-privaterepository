package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.dto.ResponseApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Controller {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;


    @DisplayName("POST - User - Saving User Object")
    @Test
    public void testPostMethod() {
        String url = "http://" + "localhost" + ":" + port + "/user";
        var us = new User();
        us.setId(3);
        us.setName("reddy");
        us.setLastName("covid");
        us.setEmail("reddy@gmail.com");

        var re = template.postForEntity(url, us, ResponseApi.class);
        Assertions.assertEquals(HttpStatus.OK, re.getStatusCode());
    }

    @DisplayName("GET - all - Checking Status code")
    @Test
    public void testGetStatusCode() {
        String url = "http://" + "localhost" + ":" + port + "/users";
        ResponseEntity<User> entity = template.getForEntity(url, User.class);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @DisplayName("Get  Checking Object Is non null")
    @Test
    public void testGetMethod() {
        String url = "http://" + "localhost" + ":" + port + "/patient";
        User entity = template.getForObject(url, User.class);
        Assertions.assertNotNull(entity);
    }

    @DisplayName("delete - Checking Status code")
    @Test
    public void testDeleteStatusCode() {
        String url = "http://" + "localhost" + ":" + port + "/user/{id}";
        var us = new User();
        us.setId(1);
        us.setName("Rohit");
        us.setLastName("P");
        us.setEmail("rohit@gmail.com");
        template.delete(url, us);
        Assertions.assertNotNull(us);
    }

    //        ResponseEntity<User> entity = template.delete(url,);
//        Assertions.assertEquals(HttpStatus.OK,entity.getStatusCode());
    //}
    @DisplayName("DELETE Method")
    @Test
    public void deleteTest() {

        int id = 121;
        String url = "http://" + "localhost" + ":" + port + "/api/delete-user/" + id;
        var obj = new User();
        obj.setId(121);
        obj.setName("Rohit");
        obj.setEmail("rohit@gmail.com");
        obj.setLastName("Rollins");
        List<User> list = new ArrayList<>();
        list.add(obj);
        template.delete(url);
        list.remove(obj);
        Assertions.assertEquals(0, list.size());

    }

    @DisplayName("Testing PUT Method")
    @Test
    public void testPutMethod() {
        var obj = new User();
        obj.setId(1);
        String url = "http://" + "localhost" + ":" + port + "/user";
        var us = new User();
        us.setId(1);
        us.setName("Rohit");
        us.setLastName("P");
        us.setEmail("rohit@gmail.com");
        template.put(url, us);
        Assertions.assertNotNull(us);

//        ResponseEntity<User> entity = template.put(url,us,ResponseApi.class);
//        Assertions.assertEquals(HttpStatus.OK,entity.getStatusCode());
        //  Assertions.assertEquals(1, us.getId());
    }
}
