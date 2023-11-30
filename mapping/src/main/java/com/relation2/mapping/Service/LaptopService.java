package com.relation2.mapping.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.relation2.mapping.entity.Laptop;

@Service
public interface LaptopService {
	
	public Laptop newOrUpdate(Laptop laptop);
	
	public List<Laptop> fetchAll();

}
