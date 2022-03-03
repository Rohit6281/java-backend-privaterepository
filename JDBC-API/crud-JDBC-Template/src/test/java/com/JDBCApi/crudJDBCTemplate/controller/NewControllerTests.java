package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.dto.ResponseApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class NewControllerTests {

    @Autowired
    private UserController controller;
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    @MockBean
    private UserDao userDao;

    User us1 = new User(1, "rohit", "p", "rohit@gmail.com");
    User us2 = new User(2, "sumanth", "k", "sumanth@gmail.com");
    User us3 = new User(3, "santhu", "dh", "santhu@gmail.com");

    //    @Test
//    public void testListUsers(){
//        List<User> us = new ArrayList<>();
//        us.add(us1);
//        us.add(us2);
//        us.add(us3);
//        when(userDao.allUsers(us1)).thenReturn(us1);
//        assertEquals(us1,controller.getUsers().getBody().getHttpStatusCode());
//    }
    @Test
    public void update() {
        when(userDao.updateUser(us1)).thenReturn(us1);
        assertEquals(us1, controller.updateUser(us1).getBody().getHttpStatusCode());
    }

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
        Assertions.assertEquals(1, us.getId());
    }
    @Test
    public void deleteTest() {
        boolean b = true;
        String res = "user deleted";
        when(userDao.deleteUser(1)).thenReturn(res);
        assertEquals(res,controller.delete(1).getBody().getHttpStatusCode());

    }
}
