package com.studentmanagement.sms.teacher;


import com.studentmanagement.sms.room.Room;
import com.studentmanagement.sms.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //Create teacher - POST
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }
    //Get teachers - GET
    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }
    //Delete teacher - DELETE
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }
    //Update teacher - PUT
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }

    @PutMapping("/{teacher_id}/student/{student_id}")
    public Teacher assignStudentToTeacher(@PathVariable Long teacher_id, @PathVariable  Long student_id){

        return teacherService.assignStudentToTeacher(teacher_id,student_id);

    }

    @PutMapping("/{teacher_id}/room")
    public Teacher assignRoomToTeacher(@PathVariable Long teacher_id, @RequestBody Room room){

        return teacherService.assignRoomToTeacher(teacher_id,room);

    }
}
