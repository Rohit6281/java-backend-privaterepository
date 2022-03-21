package com.GenericApi.controller;

import com.GenericApi.domain.User;
import com.GenericApi.dto.QueryResponse;
import com.GenericApi.dto.ResponseApi;
import com.GenericApi.service.ApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/database")
public class AppController {

    @Autowired
    private ApiService service;

    private static final String SUCCESS = "PROCESSED SUCCESS";
    private static final String FAILED = "PROCESSED FAILED";

    @PostMapping(value = "/create-users")
    @ApiOperation("To add the User info")
    @ApiResponses({@ApiResponse(code = 200, message = "User Saved"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<User>> addUser(@RequestBody User user, @RequestBody QueryResponse res) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.createUser(user, res));
            response.setMessage("Data Has Been Created  ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-users")
    @ApiOperation("To update the User info")
    @ApiResponses({@ApiResponse(code = 200, message = "User updated"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<User>> updateUsersData(@RequestBody User user, QueryResponse res) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.updateUser(user, res));
            response.setMessage("Data Has Been Updated With Primary Key ID : " + user.getId());
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<User>();
            response.setStatus(FAILED);
            response.setBody(user);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/delete-user")
    @ApiOperation("To delete the User")
    @ApiResponses({@ApiResponse(code = 200, message = "User deleted"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<String>> deleteUser(@RequestParam Integer id, @RequestBody QueryResponse user) {
        try {
            var response = new ResponseApi<String>();
            response.setStatus(SUCCESS);
            response.setBody(service.deleteUser(id, user));
            response.setMessage("Data Has Been Deleted Using Primary Key : " + id);
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ERROR OCCURRED WITH ENTERED ID : " + id);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/get-users")
    @ApiOperation("To get the User info")
    @ApiResponses({@ApiResponse(code = 200, message = "User info"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi<List<User>>> searchUsers(@RequestBody QueryResponse user) {
        try {
            var response = new ResponseApi<List<User>>();
            response.setStatus(SUCCESS);
            response.setBody(service.allUsers(user));
            response.setMessage("Users Has Been Searched SuccessFully !");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("LIST EMPTY !");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseApi<User>> findById(@RequestBody Integer id, @RequestBody QueryResponse user) {
        try {
            var response = new ResponseApi<User>();
            response.setStatus(SUCCESS);
            response.setBody(service.searchUserByID(id, user));
            response.setMessage("user has been searched by ID successfully");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ID not present");
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

}
