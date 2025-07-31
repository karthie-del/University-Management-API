package com.UniversityManagementAPI.University.STUDENTCOURSE;

import com.UniversityManagementAPI.University.STUDENT.StudentModel;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;
import com.UniversityManagementAPI.University.STUDENTCOURSE.StudentCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseModel, Long> {
    boolean existsByStudentAndCourseUnit(StudentModel student, CourseUnitModel courseUnit);
}
