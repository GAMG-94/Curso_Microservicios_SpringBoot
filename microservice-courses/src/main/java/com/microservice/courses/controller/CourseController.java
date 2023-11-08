package com.microservice.courses.controller;

import com.microservice.courses.entities.Course;
import com.microservice.courses.services.ICourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseServices courseServices;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
        courseServices.save(course);
    }

    @GetMapping("/all-courses")
    public ResponseEntity<?> findByAllCourses() {
        return ResponseEntity.ok(courseServices.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseServices.findById(id));
    }

    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse (@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseServices.findStudentsByIdCourse(idCourse));
    }

}
