package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentsRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByCourseId(long idCourse);

}
