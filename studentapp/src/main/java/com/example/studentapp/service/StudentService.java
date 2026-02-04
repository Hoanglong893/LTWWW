package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();

    Student findById(Integer id);
}