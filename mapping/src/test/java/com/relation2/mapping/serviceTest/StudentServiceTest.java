package com.relation2.mapping.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.relation2.mapping.Service.StudentServiceImpl;
import com.relation2.mapping.entity.Student;
import com.relation2.mapping.repository.StudentRepository;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository repo;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testAddOrUpdateWithNewStudent() {
        
    	Student newStudent = new Student("Dhruv", 85, null);
    	newStudent.setId(1L);
    	
    	when(repo.findById(1L)).thenReturn(Optional.empty());
    	when(repo.save(any(Student.class))).thenReturn(newStudent);
    	
    	Student result = studentService.addOrUpdate(newStudent);
    	
    	assertEquals(newStudent, result);
    	verify(repo, times(1)).save(any(Student.class));
    	
        
    }
    
    @Test
    public void testAddOrUpdateWithExistingStudent() {

        Student existingStudent = new Student("Alice", 85, null);
        existingStudent.setId(1L);
        Student updatedStudent = new Student("Updated Alice", 90, null);
        updatedStudent.setId(1L);

 
        when(repo.findById(1L)).thenReturn(Optional.of(existingStudent));
        when(repo.save(any(Student.class))).thenReturn(updatedStudent);


        Student result = studentService.addOrUpdate(updatedStudent);

      
        assertEquals(updatedStudent, result);
        verify(repo, times(1)).save(any(Student.class));
    }

    @Test
    public void testFetchAll() {
       
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Bob", 88, null));
        studentList.add(new Student("Charlie", 92, null));

        
        when(repo.findAll()).thenReturn(studentList);

       
        List<Student> result = studentService.fetchAll();

        
        assertEquals(studentList.size(), result.size());
        assertTrue(result.containsAll(studentList));
        verify(repo, times(1)).findAll(); 
    }
    
}
