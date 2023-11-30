package com.relation2.mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relation2.mapping.Service.StudentService;
import com.relation2.mapping.entity.Student;




@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	
	@PostMapping("/createNewStudent")
	public ResponseEntity<Student> addOrUpdate(@RequestBody Student student) {
	    Student createdOrUpdatedStudent = studentService.addOrUpdate(student);
	    return new ResponseEntity<>(createdOrUpdatedStudent, HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllStudents") 
	public List<Student> getAllStudent()
	{
		List<Student> studentList = studentService.fetchAll();
		return studentList;
	}

}
