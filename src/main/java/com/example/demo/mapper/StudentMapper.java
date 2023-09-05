package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

  @Insert(
      "INSERT INTO work_student(id, student_id_card, "
          + "student_name, student_class, password) "
          + "VALUES (#{id},#{idCard},#{name},#{inClass},#{password})")
  boolean insertStu(Student student);

  @Select(
      "SELECT * FROM work_student WHERE student_id_card = #{idCard} "
          + "AND password = #{password}")
  Student getStuByIdCardAndPWD(String idCard, String password);

  @Select("SELECT * FROM work_student WHERE student_id_card = #{idCard} ")
  Student getStuByIdCard(String idCard);
}
