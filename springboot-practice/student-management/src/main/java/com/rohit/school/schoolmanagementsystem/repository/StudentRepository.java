package com.rohit.school.schoolmanagementsystem.repository;

import com.rohit.school.schoolmanagementsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


@Query("from Student s where s.usn=:usn")
    public Student getStudentByUsn(@Param("usn") String usn);
@Query("select s.usn from Student s")
    public List<String> allStudent();
@Query("select s.name, s.emailId from Student s where s.sem=:sem")
    public List<String> nameAndEmail(@Param("sem") int sem);
@Query("select s.sem from Student s where s.sem = sem")
    public List<Student> getSem(@Param("sem") int sem);
@Query("from Student s where s.name = :name")
    public Student findByName(@Param("name") String name);
}
