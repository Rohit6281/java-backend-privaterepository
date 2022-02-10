package com.rohit.school.schoolmanagementsystem.service;

import com.rohit.school.schoolmanagementsystem.domain.Student;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidEmailException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidSemException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidStudentNameException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidUsnException;

import java.util.List;

public interface StudentService {
    public int createStudentInfo( Student st);
    public List<Student> findAll();
    public Student findStudentByName(String name)throws InvalidStudentNameException;
    public Student findStudentNameByUsn(String usn)throws InvalidUsnException;
    public List<String> findAllUsn() throws InvalidUsnException;
    public Student updateEmail(Student s)throws InvalidEmailException;
    public List<String> findStudentsNameAndEmailBySem(int sem)throws InvalidSemException;
    public List<Student> findAllStudentWhoSemis7thSem(int sem) throws InvalidSemException;
    public Student updateSem(Student s);
    public Student deleteStudent(String usn)throws InvalidUsnException;

}
