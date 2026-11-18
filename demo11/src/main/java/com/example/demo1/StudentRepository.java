package com.example.demo1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo1.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    List<Student> findByNameStartingWith(String letter);

}
