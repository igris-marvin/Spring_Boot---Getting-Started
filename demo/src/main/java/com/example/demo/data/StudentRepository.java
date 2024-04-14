package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}
