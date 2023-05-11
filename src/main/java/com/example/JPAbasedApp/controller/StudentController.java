package com.example.JPAbasedApp.controller;

import com.example.JPAbasedApp.enums.Department;
import com.example.JPAbasedApp.model.Student;
import com.example.JPAbasedApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student, @RequestParam Department department) {
        return studentService.addStudent(student, department);
    }

    @GetMapping("/get/{id}") // Debug needed postman throws Error : aborted
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/deleteById")
    public String deleteStudentById(@RequestParam("id") Integer id) {
        return studentService.deleteStudentById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllStudents() {
        return studentService.deleteAllStudents();
    }

    @PutMapping("/updateName/{id}/{name}")
    public String updateStudentName(@PathVariable Integer id, @PathVariable String name) {
        return studentService.updateStudentName(id, name);
    }

    @GetMapping("/getByAge")
    public List<String> getByAge(@RequestParam("age") Integer age) {
        return studentService.getByAge(age);
    }

    @GetMapping("/getByAgeAndMarks")
    public List<String> getByAgeAndMarks(@RequestParam("age") Integer age,
                                         @RequestParam("marks") Integer marks) {
        return studentService.getByAgeAndMarks(age, marks);
    }

    @GetMapping("/getByAgeGreaterThan")
    public List<String> getByAgeGreaterThan(@RequestParam("age") Integer age) {
        return studentService.getByAgeGreaterThan(age);
    }

}
