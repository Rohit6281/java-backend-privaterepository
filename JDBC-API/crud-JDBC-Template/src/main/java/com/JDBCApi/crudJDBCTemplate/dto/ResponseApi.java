package com.JDBCApi.crudJDBCTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi<T> {
    private T body;
    private String status;
    private String httpStatusCode;
    private String message;
}
