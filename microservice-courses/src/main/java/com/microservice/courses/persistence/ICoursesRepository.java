package com.microservice.courses.persistence;

import com.microservice.courses.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursesRepository extends CrudRepository<Course, Long> {

}
