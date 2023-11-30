package com.relation2.mapping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relation2.mapping.entity.Laptop;

public interface LaptopReoopsitory extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findAll();

	List<Laptop> findByLid(long lid);

}
