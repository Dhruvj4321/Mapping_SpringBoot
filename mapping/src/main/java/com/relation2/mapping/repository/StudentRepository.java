package com.relation2.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relation2.mapping.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findAll();


}
