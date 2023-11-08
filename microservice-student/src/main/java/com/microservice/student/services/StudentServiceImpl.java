package com.microservice.student.services;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.IStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentsRepository IStudentsRepository;
    @Override
    public List<Student> findAll() {
        return (List<Student>) IStudentsRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return IStudentsRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        IStudentsRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return IStudentsRepository.findAllByCourseId(idCourse);
    }
}
