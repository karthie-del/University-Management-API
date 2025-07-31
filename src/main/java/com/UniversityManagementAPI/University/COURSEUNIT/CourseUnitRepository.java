package com.UniversityManagementAPI.University.COURSEUNIT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.UniversityManagementAPI.University.COURSEUNIT.CourseUnitModel;

@Repository
public interface CourseUnitRepository extends JpaRepository<CourseUnitModel, Long> {
}
