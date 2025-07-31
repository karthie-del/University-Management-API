package com.UniversityManagementAPI.University.STUDENTCOURSE;

import jakarta.persistence.*;
import lombok.Data;
import com.UniversityManagementAPI.University.STUDENT.StudentModel;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;

@Entity
@Data
@Table(name = "student_course")
public class StudentCourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "course_unit_id")
    private CourseUnitModel courseUnit;
}



