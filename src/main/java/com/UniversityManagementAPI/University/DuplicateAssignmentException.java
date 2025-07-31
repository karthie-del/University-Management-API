package com.UniversityManagementAPI.University;

public class DuplicateAssignmentException extends RuntimeException{
    public DuplicateAssignmentException(String message) {
        super(message);
    }
}
