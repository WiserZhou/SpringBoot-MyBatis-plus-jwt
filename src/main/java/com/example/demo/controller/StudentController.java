package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.util.PassToken;
import com.example.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/work_student")
public class StudentController {
  @Autowired StudentService studentService;

  @PassToken
  @GetMapping("/get")
  public String getNowTimeAsString() {
    return "hello";
  }
}
