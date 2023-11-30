package com.relation2.mapping.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.relation2.mapping.entity.Student;

@Service
public interface StudentService {
	
	public Student addOrUpdate(Student student);
	
	public List<Student> fetchAll();

}
