package com.studentmanagement.sms.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studentmanagement.sms.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String room;

    @JsonIgnore
    @OneToOne(mappedBy = "room")
    private Teacher teacher;
}
