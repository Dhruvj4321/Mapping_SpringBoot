package com.relation2.mapping.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.relation2.mapping.entity.Student;
import com.relation2.mapping.repository.StudentRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {
	
	
	@Autowired
	StudentRepository repo;
	
	@Test
	public void testFindAll(){
		
		Student s1 = new Student("Dhruv", 82, null);
		Student s2 = new Student("Jatin", 100, null);
		
		repo.save(s1);
		repo.save(s2);
		
		List<Student> students = repo.findAll();
		
		assertEquals(2, students.size());
		assertEquals("Dhruv", students.get(0).getName());
		assertEquals(82, students.get(0).getMarks());
        assertEquals("Jatin", students.get(1).getName());
        assertEquals(100, students.get(1).getMarks());
		
	}

}
