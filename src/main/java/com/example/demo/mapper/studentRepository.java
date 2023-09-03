package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface studentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor {


}
