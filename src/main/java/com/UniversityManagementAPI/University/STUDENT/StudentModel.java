package com.UniversityManagementAPI.University.STUDENT;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import com.UniversityManagementAPI.University.STUDENTCOURSE.StudentCourseModel;

@Entity
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCourseModel> courses;
}
