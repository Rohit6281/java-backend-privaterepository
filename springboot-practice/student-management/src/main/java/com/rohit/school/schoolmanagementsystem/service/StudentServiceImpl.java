package com.rohit.school.schoolmanagementsystem.service;

import com.rohit.school.schoolmanagementsystem.domain.Student;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidEmailException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidSemException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidStudentNameException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidUsnException;
import com.rohit.school.schoolmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Transactional (isolation = Isolation.READ_UNCOMMITTED,
                 rollbackFor = SQLException.class,
        noRollbackFor = InvalidEmailException.class)
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public int createStudentInfo(Student st) {
        repository.save(st);
        return 1;
    }

    @Override
    public List<Student> findAll() {
        List<Student> s = repository.findAll();
        return s;
    }

    @Override
    public Student findStudentByName(String name) throws InvalidStudentNameException {
       return repository.findByName(name);
    }

    @Override
    public Student findStudentNameByUsn(String usn)throws InvalidUsnException {
        return repository.getStudentByUsn(usn);
    }

    @Override
    public List<String> findAllUsn() throws InvalidUsnException {
  try {
      List<String> a = repository.allStudent();
      return a;
  }
  catch (InvalidUsnException u){
      throw new InvalidUsnException("enter a valid usn");
  }
    }

    @Override
    public Student updateEmail(Student s) throws InvalidEmailException {
        Student exStudent = repository.getStudentByUsn(s.getUsn());
        if(exStudent == null){
            throw new InvalidEmailException("invalid email id");
        }

        if (exStudent != null) {
            exStudent.setEmailId(s.getEmailId());
            repository.save(exStudent);
        }
        return exStudent;

    }

    @Override
    public List<String> findStudentsNameAndEmailBySem(int sem) throws InvalidSemException {
        try {
            return repository.nameAndEmail(sem);
        }
        catch(InvalidSemException s){
            throw new InvalidSemException(" enter a valid sem");
        }
    }

    @Override
    public List<Student> findAllStudentWhoSemis7thSem(int sem) throws InvalidSemException{
        if (sem == 7) {
            return repository.getSem(sem);
        }
        return null;
    }

    @Override
    public Student updateSem(Student s) throws InvalidSemException {
        Student s1 =repository.getStudentByUsn(s.getUsn());
        if(s1 != null){
            s1.setSem(s.getSem());
            repository.save(s1);
        }
       return s1;

    }

    @Override
    public Student deleteStudent(String usn) throws InvalidUsnException{
        Student exStudent = repository.getStudentByUsn(usn);
        if (exStudent != null) {
            repository.delete(exStudent);
        }
        return exStudent;
    }
}


