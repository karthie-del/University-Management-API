package com.UniversityManagementAPI.University.COURSEUNIT;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.UniversityManagementAPI.University.STUDENTCOURSE.StudentCourseModel;

@Entity
@Data
public class CourseUnitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  boolean active;

    @OneToMany(mappedBy = "courseUnit", cascade = CascadeType.ALL)
    private List<StudentCourseModel> students;
}
