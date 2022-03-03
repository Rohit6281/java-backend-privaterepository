package com.JDBCApi.crudJDBCTemplate.exceptions;

public class UserAlreadyTakenException extends RuntimeException{
    public UserAlreadyTakenException(String message) {
        super(message);
    }
}
