package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pojo.Student;
import com.pojo.Teacher;

public interface StudentMapper {
	@Select("select t.id `teacher.id`,t.name`teacher.name`,s.id id,s.name name, age,tid from student s left join teacher t on t.id=s.tid")
	List<Student> selAll();
	
	@Select("select * from student where tid=#{0}")
	Student selById(int id);
	
	@Results(value= {
			@Result(id=true,column="id",property="id"),
			@Result(property="name",column="name"),
			@Result(property="age",column="age"),
			@Result(property="tid",column="tid"),
			@Result(property="teacher",column="tid",one=@One(select="com.mapper.TeacherMapper.selById"))
		})
		@Select("select * from student")
		List<Student> selAll1();

}
