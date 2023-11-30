package com.relation2.mapping.Service;

import java.util.ArrayList;
import java.util.List;





import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.relation2.mapping.entity.Laptop;
import com.relation2.mapping.entity.Student;
import com.relation2.mapping.repository.StudentRepository;




@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository repo;

	@Override
	public Student addOrUpdate(Student student) {
		// TODO Auto-generated method stub
		
		
		try {
            Optional<Student> existingStudent = repo.findById(student.getId());

            if (existingStudent.isPresent()) {
                Student existing = existingStudent.get();
                existing.setName(student.getName());
                existing.setMarks(student.getMarks());

                
                if (student.getLaptopList() != null) {
                    updateLaptops(existing, student.getLaptopList());
                }

                return repo.save(existing);
            } else {
                return repo.save(student);
            }
        } catch (Exception e) {
            
            throw e;
        }
    }
	
	public void updateLaptops(Student existing, List<Laptop> newLaptops) {
        List<Laptop> existingLaptops = existing.getLaptopList();
        
        if(existingLaptops==null)
        {
        	existingLaptops = new ArrayList<>();
        }
        else {

            existingLaptops.clear();
        }
        
        if (newLaptops != null) {
            existingLaptops.addAll(newLaptops);
        }
        
    }

	@Override
	public List<Student> fetchAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
