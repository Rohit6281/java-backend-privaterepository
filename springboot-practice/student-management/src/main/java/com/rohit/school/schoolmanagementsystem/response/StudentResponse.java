package com.rohit.school.schoolmanagementsystem.response;

import lombok.Data;

@Data
public class StudentResponse <T>{
    private String sts;
    private String msg;
    private T body;
}
