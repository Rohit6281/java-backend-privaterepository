package com.rohit.school.schoolmanagementsystem.controller;

import com.rohit.school.schoolmanagementsystem.domain.Student;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidEmailException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidSemException;
import com.rohit.school.schoolmanagementsystem.exceptions.InvalidUsnException;
import com.rohit.school.schoolmanagementsystem.response.StudentResponse;
import com.rohit.school.schoolmanagementsystem.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<StudentResponse<List<Student>>> findAll() {
        var response = new StudentResponse<List<Student>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.findAll());

        return ResponseEntity.ok(response);

    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createStudent(@RequestBody Student st) {
         var c= service.createStudentInfo(st);
        var response = new StudentResponse<Integer>();
        response.setMsg("account activated");
        response.setSts("success");
        response.setBody(c);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getStudent/{usn}")
    public Student getStudentName(@PathVariable String usn) {
        return service.findStudentNameByUsn(usn);
    }

    @GetMapping("/getStudent/{name}")
    public Student getStudentByName(@PathVariable String name){
        return service.findStudentByName(name);
    }

    @GetMapping("/allUsn")
    public ResponseEntity<StudentResponse<List<String>>> allUsn() throws InvalidUsnException {
        try {
            var response = new StudentResponse<List<String>>();
            response.setMsg("account list");
            response.setSts("success");
            response.setBody(service.findAllUsn());
            return new ResponseEntity<>(response ,  HttpStatus.ACCEPTED);
        }
        catch(InvalidUsnException us){
            var response1 = new StudentResponse<List<String>>();
            response1.setMsg(us.getMessage());
            response1.setSts("fail");
            return  new ResponseEntity<>(response1,  HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getStudentNameBySem/{sem}")
    public List<String> getStudentName(@PathVariable int sem) throws InvalidSemException {
        try {
            return service.findStudentsNameAndEmailBySem(sem);
        }
        catch(InvalidSemException se){
            throw new InvalidSemException("invalid sem");
        }
    }

    @GetMapping("/get7thSem/{sem}")
    public List<Student> get7sem(@PathVariable int sem ){
        return service.findAllStudentWhoSemis7thSem(sem);
    }


    @DeleteMapping("/deleteStudentDetails/{usn}")
    public String deleteStudent(@PathVariable String usn) {
        Student del = service.deleteStudent(usn);
        if (del != null) {
            return "student deleted with usn no " + del.getUsn();
        }
        return "data cannot be deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody Student s) throws InvalidEmailException{
      try {
          Student update = service.updateEmail(s);
          if (update != null) {
              return "student update " + update.getEmailId();
          }
          return "student can't be updated";
      }
      catch(InvalidEmailException e){
          throw new InvalidEmailException("invalid usn");
      }
    }

    @PutMapping("/updateSem")
    public ResponseEntity<Student> updateSem(@RequestBody Student s){
        Student sem = service.updateSem(s);
        var response = new StudentResponse<Student>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(sem);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);

    }
}
