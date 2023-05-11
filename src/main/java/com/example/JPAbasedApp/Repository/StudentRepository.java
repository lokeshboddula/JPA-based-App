package com.example.JPAbasedApp.Repository;

import com.example.JPAbasedApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> getByAge(Integer age);

    List<Student> getByAgeAndMarks(Integer age, Integer marks);

    @Query(value = "select * from student_info s where s.age > :age", nativeQuery = true)
    List<Student> getByAgeGreaterThan(Integer age);
}
