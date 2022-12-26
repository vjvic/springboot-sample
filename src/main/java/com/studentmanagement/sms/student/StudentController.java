package com.studentmanagement.sms.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(value="id") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }



}
