package com.studentmanagement.sms.teacher;

import com.studentmanagement.sms.room.Room;
import com.studentmanagement.sms.room.RoomService;
import com.studentmanagement.sms.student.Student;
import com.studentmanagement.sms.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoomService roomService;

    //Create teacher
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    //Get teacher
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    //Delete teacher
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }
    //Update teacher
    public Teacher updateTeacher(Long id, Teacher newTeacher){
       Teacher t = teacherRepository.findById(id).get();
       t.setName(newTeacher.getName());
       t.setSubject(newTeacher.getSubject());

       return teacherRepository.save(t);
    }

    //Assign student to teacher

    public Teacher assignStudentToTeacher(Long teacher_id, Long student_id){
        Teacher newTeacher = teacherRepository.findById(teacher_id).get();
        Student newStudent = studentRepository.findById(student_id).get();
        newTeacher.myStudent.add(newStudent);

        return teacherRepository.save(newTeacher);

    }

    public Teacher assignRoomToTeacher(Long teacher_id, Room room){
        Teacher newTeacher = teacherRepository.findById(teacher_id).get();
        Room newRoom = roomService.createRoom(room);

        newTeacher.setRoom(newRoom);
        return teacherRepository.save(newTeacher);

    }
}
