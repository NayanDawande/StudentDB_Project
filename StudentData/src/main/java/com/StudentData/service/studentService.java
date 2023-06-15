package com.StudentData.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentData.entity.Student;


public interface studentService{

	

	public List<Student> allStudent();
	
	public Student add(Student student);

	public void deleteSingleRecord(int id);

	public Student updateStudent(Student emp, int id);
	
	
	
}
