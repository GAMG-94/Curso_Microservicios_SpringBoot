package com.microservice.courses.services;

import com.microservice.courses.entities.Course;
import com.microservice.courses.http.response.StudentsByCourseResponse;

import java.util.List;

public interface ICourseServices {

    List<Course>  findAll();

    Course findById(Long id);

    void save (Course course);

    StudentsByCourseResponse findStudentsByIdCourse(Long idCourse);

}
