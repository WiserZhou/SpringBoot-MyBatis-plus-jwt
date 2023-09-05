package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("work_student")
public class Student {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @TableField(
      value = "student_id_card",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String idCard;

  @TableField(
      value = "student_name",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String name;

  @TableField(
      value = "student_class",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String inClass;

  @TableField(
      value = "password",
      insertStrategy = FieldStrategy.NOT_NULL,
      updateStrategy = FieldStrategy.NOT_EMPTY)
  private String password;
}
