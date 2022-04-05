package com.GenericApi.controller;


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
    public ResponseEntity<ResponseApi> addUser( @RequestBody QueryResponse res) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.createUser( res));
            response.setMessage("Data Has Been Created  ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi();
            response.setStatus(FAILED);
            response.setBody(res);
            response.setMessage(e.getMessage());
            HttpStatus code = ResponseEntity.badRequest().build().getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/update-users")
    @ApiOperation("To update the User info")
    @ApiResponses({@ApiResponse(code = 200, message = "User updated"),
            @ApiResponse(code = 404, message = "Class not found"),
            @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> updateUsersData(@RequestBody QueryResponse res) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.updateUser(res));
            response.setMessage("Data Has Been Updated With Primary Key ID : " );
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi();
            response.setStatus(FAILED);
            response.setBody(res);
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
    public ResponseEntity<ResponseApi> deleteUser( @RequestBody QueryResponse user) {
        try {
            var response = new ResponseApi();
            response.setStatus(SUCCESS);
            response.setBody(service.deleteUser( user));
            response.setMessage("Data Has Been Deleted Using Primary Key  ");
            HttpStatus code = ResponseEntity.ok(response).getStatusCode();
            response.setHttpStatusCode(String.valueOf(code));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            var response = new ResponseApi<>();
            response.setStatus(FAILED);
            response.setBody("ERROR OCCURRED WITH ENTERED ID ");
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
    public ResponseEntity<ResponseApi<List<Object>>> searchUsers(@RequestBody QueryResponse res) {
        try {
            var response = new ResponseApi<List<Object>>();
            response.setStatus(SUCCESS);
            response.setBody(service.allUsers(res));
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
     @PostMapping(value = "/get-byId")
     @ApiOperation("To get the User info")
     @ApiResponses({@ApiResponse(code = 200, message = "User info"),
             @ApiResponse(code = 404, message = "Class not found"),
             @ApiResponse(code = 500, message = "Internal Server error")})
    public ResponseEntity<ResponseApi> findById( @RequestBody QueryResponse user) {
        try {
            var response = new ResponseApi<>();
            response.setStatus(SUCCESS);
            response.setBody(service.searchUserByID( user));
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
