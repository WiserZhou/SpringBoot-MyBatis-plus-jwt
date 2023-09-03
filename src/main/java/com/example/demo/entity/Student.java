package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "work_student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "studentIdCard")
  private String idCard;

  @Column(name = "studentName")
  private String name;

  @Column(name = "studentClass")
  private String inClass;

  @Column(name = "password")
  private String password;
}
