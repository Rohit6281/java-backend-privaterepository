package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userDao.createUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userDao.updateUser(user);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.allUsers();
    }
    @DeleteMapping("/user/{id}")
    public String delete (@PathVariable("id") int id){
        return userDao.deleteUser(id);
    }
}
