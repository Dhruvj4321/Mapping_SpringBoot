package com.relation2.mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.relation2.mapping.entity.Laptop;
import com.relation2.mapping.repository.LaptopReoopsitory;

@Service
public class LaptopServiceImpl implements LaptopService {
	
	@Autowired
	LaptopReoopsitory repo;

	@Override
	public Laptop newOrUpdate(Laptop laptop) {
		// TODO Auto-generated method stub
		
        Optional<Laptop> existingLaptop = repo.findById(laptop.getId()); 
		
		if(existingLaptop.isPresent())
		{
			Laptop existing = new Laptop();
			existing.setLid(laptop.getLid());
			existing.setModel(laptop.getModel());
			return repo.save(existing);
		}
		else
		{
			return repo.save(laptop);
		}
		
		
		
	}

	@Override
	public List<Laptop> fetchAll() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

}
