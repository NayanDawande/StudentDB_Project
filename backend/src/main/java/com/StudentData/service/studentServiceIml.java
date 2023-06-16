package com.StudentData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentData.dao.studentRepository;
import com.StudentData.entity.Student;



@Service
public class studentServiceIml implements studentService {

	
	
	@Autowired
	private studentRepository studentRepository;
	

	@Override
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student add(Student student) {
		
		return studentRepository.save(student);
	}	

	@Override
	public void deleteSingleRecord(int id) {
		
		  studentRepository.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Student newStudent, int id) {
		Student students  = new Student();
		students.setId(newStudent.getId());
		students.setName(newStudent.getName());
		students.setStandard(newStudent.getStandard());
		students.setSection(newStudent.getSection());
		students.setPhone(newStudent.getPhone());

		return studentRepository.save(students);		
	}

	
}


