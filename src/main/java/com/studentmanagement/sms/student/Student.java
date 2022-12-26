package com.studentmanagement.sms.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studentmanagement.sms.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;
    @JsonIgnore
    @ManyToMany(mappedBy = "myStudent")
    Set<Teacher> myteacher;
}
