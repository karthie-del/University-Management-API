 University-Management-API
A spring boot REST API application built as part of a University Internship Project. It manages students and course units at the university. The system allows students to register, course management and assignment of course units to students with proper validations and error handling.

 🎓 Internship Project - University Management API

 🚀 Features

- **Student APIs**
  - Register a new student
  - List all students
  - Get a student by ID
  - Update student details by ID
  - Calculate and return student age using Date of Birth

- **Course Unit APIs**
  - Register a new course unit
  - Activate/deactivate a course unit
  - Assign a course unit to a student (no duplicates allowed)
  - Retrieve all course units a specific student is taking

- **Error Handling**
  - Throws meaningful exceptions where necessary (e.g. student not found, duplicate course assignment, invalid data)

 🗃️ Database Design

 Tables

1. `students`
2. `course_units`
3. `student_courses` 

 Entity Relationships

```text
Student (1) --------- (M) StudentCourse (M) --------- (1) CourseUnit
