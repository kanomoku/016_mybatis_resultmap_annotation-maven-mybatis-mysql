package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pojo.Student;
import com.pojo.Teacher;

public interface TeacherMapper {
	@Insert("insert into teacher values(default,#{name})")
	int insTeacher(Teacher teacher);

	@Update("update teacher set name=#{name} where id =#{id}")
	int updTeacher(Teacher teacher);

	@Delete("delete from teacher where id=#{0}")
	int delTeacher(int id);

	@Select("select * from teacher")
	List<Teacher> selAll();
	
	@Results(value= {
		@Result(id=true,column="id",property="id"),
		@Result(property="name",column="name"),
		@Result(property="studentList",column="id",many=@Many(select="com.mapper.StudentMapper.selById"))
	})
	@Select("select * from teacher")
	List<Teacher> selAll1();
	
	@Select("select * from teacher where id=#{0}")
	Teacher selById(int id);

}
