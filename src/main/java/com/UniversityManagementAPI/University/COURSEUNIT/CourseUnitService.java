package com.UniversityManagementAPI.University.COURSEUNIT;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitRepository;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;
import org.springframework.stereotype.Service;

@Service
public class CourseUnitService {

    @Autowired
    private CourseUnitRepository courseRepo;

    public CourseUnitModel createCourse(CourseUnitModel c) {
        return courseRepo.save(c);
    }


    public void setActive(Long id, boolean status) {
        CourseUnitModel course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setActive(status);
        courseRepo.save(course);
    }


    public List<CourseUnitModel> getAllCourses() {
        return courseRepo.findAll();
    }
}

