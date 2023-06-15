package com.StudentData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentData.entity.Student;
import com.StudentData.service.studentService;

@RestController
public class studentController {
	@Autowired
	studentService studentService;
	
	
	

	@GetMapping("/")
	public ResponseEntity<Student> allStudent(){
		
		return new ResponseEntity<Student>((Student) studentService.allStudent(),HttpStatus.ACCEPTED) ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student){
		
		return new ResponseEntity<Student>(studentService.add(student),HttpStatus.CREATED);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> remove(@PathVariable int id){
		studentService.deleteSingleRecord(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@PutMapping("/student")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int id){
		return new ResponseEntity<Student>((HttpStatusCode) studentService.updateStudent(student, id));
	}
	
}
