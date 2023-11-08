package com.microservice.courses.services;

import com.microservice.courses.client.StudentClient;
import com.microservice.courses.dto.StudentDTO;
import com.microservice.courses.entities.Course;
import com.microservice.courses.http.response.StudentsByCourseResponse;
import com.microservice.courses.persistence.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseServices{

    @Autowired
    private ICoursesRepository coursesRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) coursesRepository.findAll() ;
    }

    @Override
    public Course findById(Long id) {
        return coursesRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        coursesRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long idCourse) {

        // Consultar el curso es lo primero
        Course course = coursesRepository.findById(idCourse).orElse(new Course());

        // Obtener los Estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(idCourse);

        return StudentsByCourseResponse.builder()
                .course(course.getName())
                .teacher(course.getTeacher())
                .studentDTOS(studentDTOList)
                .build();
    }
}
