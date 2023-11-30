package com.relation2.mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relation2.mapping.Service.LaptopService;
import com.relation2.mapping.entity.Laptop;



@RestController
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	@PostMapping("/CreateNewLaptop")
	public ResponseEntity<String> createOrUpdate(@RequestBody Laptop laptop)
	{
		laptopService.newOrUpdate(laptop);
		return ResponseEntity.ok("Success");
		
	}
	
	@GetMapping("/getAllLaptops")
	public List<Laptop> gelAllLaptops()
	{
		List<Laptop> laptopList = laptopService.fetchAll();
		return laptopList;
	}


}
