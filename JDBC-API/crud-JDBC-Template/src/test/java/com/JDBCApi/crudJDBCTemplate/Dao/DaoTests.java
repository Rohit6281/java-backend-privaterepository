package com.JDBCApi.crudJDBCTemplate.Dao;

import com.JDBCApi.crudJDBCTemplate.controller.UserController;
import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DaoTests {

    @Autowired
    private UserController controller;

    @MockBean
    private UserDao userDao;

    User us1 = new User(1, "rohit", "p", "rohit@gmail.com");
    User us2 = new User(2, "sumanth", "k", "sumanth@gmail.com");
    User us3 = new User(3, "santhu", "dh", "santhu@gmail.com");

    @Test
    public void testListUsers(){
        List<User> us = new ArrayList<>();
        us.add(us1);
        us.add(us2);
        us.add(us3);
        when(userDao.allUsers()).thenReturn((us));
        assertEquals(us,userDao.allUsers());
    }
    @Test
    public void update() {
        when(userDao.updateUser(us1)).thenReturn(us1);
        assertEquals(us1, userDao.updateUser(us1));
    }

    @Test
    public void deleteTest() {
        User us2 = new User(2, "sumanth", "k", "sumanth@gmail.com");
        userDao.deleteUser(2);
        verify(userDao,times(1)).deleteUser(2);

    }
    @Test
    public void createTest(){
        User us1 = new User(1, "rohit", "p", "rohit@gmail.com");
        when(userDao.createUser(us1)).thenReturn(us1);
        assertEquals(us1,userDao.createUser(us1));
    }
}
