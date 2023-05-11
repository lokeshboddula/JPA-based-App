package com.example.JPAbasedApp.service;

import com.example.JPAbasedApp.enums.Department;
import com.example.JPAbasedApp.model.LibraryCard;
import com.example.JPAbasedApp.model.Student;
import com.example.JPAbasedApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student, Department department) {

        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setDepartment(department);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        studentRepository.save(student);
        return "student added successfully";
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
        return "delete success";
    }

    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "all records deleted";
    }

    public String updateStudentName(Integer id, String name) {
        Student student = studentRepository.findById(id).get();
        student.setName(name);
        studentRepository.save(student);
        return "name updated";

        //studentRepository.findBy;
    }

    public List<String> getByAge(Integer age) {
        List<Student> students = studentRepository.getByAge(age);
        List<String> names = new ArrayList<>();
        for(Student student : students) names.add(student.getName());
        return names;
    }

    public List<String> getByAgeAndMarks(Integer age, Integer marks) {
        List<Student> students = studentRepository.getByAgeAndMarks(age, marks);
        List<String> names = new ArrayList<>();
        for(Student student : students) names.add(student.getName());
        return names;
    }

    public List<String> getByAgeGreaterThan(Integer age) {
        List<Student> students = studentRepository.getByAgeGreaterThan(age);
        List<String> names = new ArrayList<>();
        for(Student student : students) names.add(student.getName());
        return names;
    }
}
