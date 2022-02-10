package com.rohit.school.schoolmanagementsystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer  id;
    @Column(nullable = false)
    private String name;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String  emailId;
    @Column(unique = true,nullable = false)
    private String usn;
    private int sem;
}
