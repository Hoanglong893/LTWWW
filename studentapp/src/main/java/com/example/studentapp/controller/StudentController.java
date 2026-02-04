package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    // ✅ Constructor Injection
    public StudentController(StudentService service) {
        this.service = service;
    }

    // POST: Thêm sinh viên
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }

    // GET: Xem tất cả sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return service.findAll();
    }

    // GET: Xem sinh viên theo ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.findById(id);
    }
}