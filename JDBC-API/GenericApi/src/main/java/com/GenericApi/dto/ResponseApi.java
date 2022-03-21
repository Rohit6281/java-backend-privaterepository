package com.GenericApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi<T> {
    private T body;
    private String status;
    private String message;
    private String httpStatusCode;
}
