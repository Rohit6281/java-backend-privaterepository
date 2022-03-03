package com.JDBCApi.crudJDBCTemplate.exceptions;

public class FieldEmptyException extends RuntimeException{
    public FieldEmptyException(String message) {
        super(message);
    }
}
