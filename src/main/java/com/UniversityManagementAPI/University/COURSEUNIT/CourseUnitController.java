package com.UniversityManagementAPI.University.COURSEUNIT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitService;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;

@RestController
@RequestMapping("/api/courses")
public class CourseUnitController {

    @Autowired
    private CourseUnitService service;

    @PostMapping
    public CourseUnitModel create(@RequestBody CourseUnitModel course) {
        return service.createCourse(course);
    }

    @PutMapping("/{id}/activate")
    public void activate(@PathVariable Long id) {
        service.setActive(id, true);
    }


    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.setActive(id, false);
    }

    @GetMapping
    public List<CourseUnitModel> getAll() {
        return service.getAllCourses();
    }
}

