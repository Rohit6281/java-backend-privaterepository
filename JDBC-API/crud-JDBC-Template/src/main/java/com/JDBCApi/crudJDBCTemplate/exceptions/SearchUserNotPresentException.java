package com.JDBCApi.crudJDBCTemplate.exceptions;

public class SearchUserNotPresentException extends RuntimeException {
    public SearchUserNotPresentException(String message) {
        super(message);
    }
}
