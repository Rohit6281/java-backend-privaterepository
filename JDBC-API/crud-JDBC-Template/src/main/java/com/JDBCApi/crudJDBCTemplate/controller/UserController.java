package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.dto.ResponseApi;
import com.JDBCApi.crudJDBCTemplate.exceptions.*;
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
            response.setStatus(SUCCESS);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            response.setBody(userDao.createUser(user));
            response.setMessage("Data Has Been Created For this Primary Key: "+user.getId());
            return ResponseEntity.ok(response);
        }
        catch (FieldEmptyException | UserAlreadyTakenException e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<ResponseApi<User>> updateUser(@RequestBody User user) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            response.setBody(userDao.updateUser(user));
            response.setMessage("Data Has Been Updated !");
            return ResponseEntity.ok(response);
        }
        catch (DataNotFoundException | FieldEmptyException e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<ResponseApi<List<User>>> getUsers() {
        try {
            var response = new ResponseApi<List<User>>();
            response.setStatus(SUCCESS);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            response.setBody(userDao.allUsers());
            response.setMessage("Users Has Been Searched SuccessFully !");
            return ResponseEntity.ok(response);
        }
        catch (NoRecordsException e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("LIST EMPTY !");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResponseApi<String>> delete (@PathVariable("id") int id){
        try {
            var response = new ResponseApi<String>();
            response.setStatus(SUCCESS);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            response.setBody(userDao.deleteUser(id));
            response.setMessage("Data Has Been Deleted ! ");
            return ResponseEntity.ok(response);
        }
        catch (InvalidIdException e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ERROR OCCURRED WITH ENTERED ID : " + id);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
