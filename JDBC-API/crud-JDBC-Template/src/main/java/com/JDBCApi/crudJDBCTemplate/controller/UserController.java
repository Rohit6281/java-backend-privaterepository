package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.dto.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    private static final String SUCCESS = "PROCESSED SUCCESS";
    private static final String FAILED = "PROCESSED FAILED";

    @PostMapping("/user")
    public ResponseEntity<ResponseApi<User>> addUser(@RequestBody User user) {
        try {
            var response = new ResponseApi<User>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(userDao.createUser(user));
            response.setMessage(SUCCESS);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            var response = new ResponseApi<User>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(user);
            response.setMessage(FAILED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<ResponseApi<User>> updateUser(@RequestBody User user) {
        try {
            var response = new ResponseApi<User>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(userDao.updateUser(user));
            response.setMessage(SUCCESS);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            var response = new ResponseApi<User>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(user);
            response.setMessage(FAILED);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<ResponseApi<List<User>>> getUsers() {
        try {
            var response = new ResponseApi<List<User>>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(userDao.allUsers());
            response.setMessage(SUCCESS);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            var response = new ResponseApi<>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody("ERROR OCCURRED");
            response.setMessage(FAILED);
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResponseApi<String>> delete (@PathVariable("id") int id){
        try {
            var response = new ResponseApi<String>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody(userDao.deleteUser(id));
            response.setMessage(SUCCESS);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            var response = new ResponseApi<>();
            response.setHttpStatusCode(response.getHttpStatusCode());
            response.setBody("ERROR OCCURRED WITH ENTERED ID : "+id);
            response.setMessage(FAILED);
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }
}
