package com.JDBCApi.crudJDBCTemplate.exceptions;

public class NoRecordsException extends RuntimeException{
    public NoRecordsException(String message) {
        super(message);
    }
}
