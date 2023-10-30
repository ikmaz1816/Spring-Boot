package com.springboot.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tblstudent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @Column(name="studentId")
    private long id;

    @Column(name="studentName",
        nullable = false
    )
    private String name;

    @Column(name="studentAddress",
        nullable = false
    )
    private String address;

    @Column(name="bloodGroup",
        nullable = false
    )
    private char bloodGroup;

    @Column(name="yearOfAdmission",
        nullable = false
    )
    private String yearOFAdmission;

    @Column(name="courseName",
        nullable = false
    )
    private String courseName;
}
