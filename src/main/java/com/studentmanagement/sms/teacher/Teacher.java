package com.studentmanagement.sms.teacher;

import com.studentmanagement.sms.room.Room;
import com.studentmanagement.sms.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="subject")
    private String subject;

    @ManyToMany
    @JoinTable(
            name = "my_student",
            joinColumns = @JoinColumn(name="teacher_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    Set<Student> myStudent;
    @OneToOne
    @JoinColumn(name="room_id")
    private Room room;

}
