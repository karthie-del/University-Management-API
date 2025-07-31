package com.UniversityManagementAPI.University.STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.Period;
import java.time.LocalDate;

import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitRepository;
import com.UniversityManagementAPI.University.STUDENTCOURSE.StudentCourseModel;
import com.UniversityManagementAPI.University.STUDENTCOURSE.StudentCourseRepository;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepo;
    @Autowired private CourseUnitRepository courseUnitRepo;
    @Autowired private StudentCourseRepository studentCourseRepo;

    public StudentModel createStudent(StudentModel s) {
        return studentRepo.save(s);
    }

    public List<StudentModel> getAllStudents() {
        return studentRepo.findAll();
    }

    public StudentModel getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Student not found with id: " + id));
    }

    public int calculateAge(Long id) {
        StudentModel student = getStudentById(id);
        return Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
    }

    public StudentModel updateStudent(Long id, StudentModel newStudent) {
        StudentModel existing = getStudentById(id);
        existing.setName(newStudent.getName());
        existing.setDateOfBirth(newStudent.getDateOfBirth());
        return studentRepo.save(existing);
    }

    public void assignCourse(Long studentId, Long courseId) {
        StudentModel student = getStudentById(studentId);
        CourseUnitModel course = courseUnitRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        boolean exists = studentCourseRepo.existsByStudentAndCourseUnit(student, course);
        if (exists) {
            throw new RuntimeException("Course already assigned to student");
        }

        StudentCourseModel sc = new StudentCourseModel();
        sc.setStudent(student);
        sc.setCourseUnit(course);
        studentCourseRepo.save(sc);
    }

    public List<CourseUnitModel> getCoursesForStudent(Long studentId) {
        StudentModel student = getStudentById(studentId);
        return student.getCourses().stream().map(StudentCourseModel::getCourseUnit).toList();
    }
}