package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.StudentMapper;
import com.mapper.TeacherMapper;
import com.pojo.Student;
import com.pojo.Teacher;

public class Test {
	public static void main(String[] args) {
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
//			六.MyBatis 注解
//			1. 注解:为了简化配置文件.
//			2. Mybatis 的注解简化mapper.xml 文件.
//				2.1 如果涉及动态SQL 依然使用mapper.xml
//			3. mapper.xml 和注解可以共存.
//			4. 使用注解时mybatis.xml 中<mappers>使用
//				4.1 <package/>
//				4.2 <mapper class=””/>
//			5. 实现查询
//			6. 实现新增
//			7. 实现修改
//			8. 实现删除
//			TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//			Teacher t = new Teacher();
//			t.setId(4);
//			t.setName("老师4");
//			int insTeacher = teacherMapper.insTeacher(t);
//			int insTeacher1 = teacherMapper.updTeacher(t);
//			List<Teacher> selAll = teacherMapper.selAll();
//			for (Teacher teacher : selAll) {
//				System.out.println(teacher);
//			}
//			int insTeacher2 = teacherMapper.delTeacher(3);
			
//			9. 使用注解实现<resultMap>功能
//				9.1 以N+1 举例
//				9.2 在StudentMapper 接口添加查询
//				9.3 在TeacherMapper 接口添加
//					9.3.1 @Results() 相当于<resultMap>
//					9.3.2 @Result() 相当于<id/>或<result/>
//						9.3.2.1 @Result(id=true) 相当与<id/>
//					9.3.3 @Many() 相当于<collection/>
//					9.3.4 @One() 相当于<association/>

			/*使用注解 实现关联集合对象(N+1 方式)*/
			TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
			List<Teacher> selAll1 = teacherMapper.selAll1();
			for (Teacher teacher : selAll1) {
//				System.out.println(teacher);
			}
			/*使用注解 实现关联集合对象(联合查询 方式)*/
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			/*使用注解查询关联 单个对象(联合查询方式)*/
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			List<Student> selAll2 = studentMapper.selAll1();
			for (Student student : selAll2) {
//				System.out.printOln(student);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			/*使用注解查询关联 单个对象N+1方式)*/
			StudentMapper studentMapper1 = sqlSession.getMapper(StudentMapper.class);
			List<Student> selAll21 = studentMapper.selAll();
			for (Student student : selAll21) {
//				System.out.println(student);
			}

			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
