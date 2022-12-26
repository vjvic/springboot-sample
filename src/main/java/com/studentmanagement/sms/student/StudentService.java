package com.studentmanagement.sms.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //Create student
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    //Get student list
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    //Delete student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    //Update student
    public Student updateStudent(Long id, Student newStudent){
        Student stud = studentRepository.findById(id).get();
        stud.setName(newStudent.getName());
        stud.setAge(newStudent.getAge());
        stud.setGender(newStudent.getGender());

        return studentRepository.save(stud);
    }


}
