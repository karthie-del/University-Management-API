package com.UniversityManagementAPI.University.STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.UniversityManagementAPI.University.STUDENT.StudentService;
import com.UniversityManagementAPI.University.STUDENT.StudentModel;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentModel register(@RequestBody StudentModel s) {
        return service.createStudent(s);
    }


    @GetMapping
    public List<StudentModel> getAll() {
        return service.getAllStudents();
    }


    @GetMapping("/{id}")
    public StudentModel getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }


    @PutMapping("/{id}")
    public StudentModel update(@PathVariable Long id, @RequestBody StudentModel s) {
        return service.updateStudent(id, s);
    }


    @GetMapping("/{id}/age")
    public int getAge(@PathVariable Long id) {
        return service.calculateAge(id);
    }


    @PostMapping("/{studentId}/assign/{courseId}")
    public void assignCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        service.assignCourse(studentId, courseId);
    }


    @GetMapping("/{id}/courses")
    public List<CourseUnitModel> getCourses(@PathVariable Long id) {
        return service.getCoursesForStudent(id);
    }
}
