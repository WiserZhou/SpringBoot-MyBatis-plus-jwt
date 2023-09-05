package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {
  @Autowired StudentMapper studentMapper;

  @Override
  public boolean registerForStu(Student student) {
    if (studentMapper.getStuByIdCard(student.getIdCard()) != null) return false;
    return studentMapper.insertStu(student);
  }
}
