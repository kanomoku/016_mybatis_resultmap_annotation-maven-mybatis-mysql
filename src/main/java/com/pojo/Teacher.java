package com.pojo;

import java.util.List;

public class Teacher {
	private int id;
	private String name;
	private List<Student> studentList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", studentList=" + studentList + "]";
	}

	
	
}
