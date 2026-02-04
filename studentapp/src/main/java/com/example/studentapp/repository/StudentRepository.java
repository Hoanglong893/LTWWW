package com.example.studentapp.repository;

import com.example.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository đã cung cấp sẵn các method:
    // save(), findAll(), findById(), deleteById(), etc.
}