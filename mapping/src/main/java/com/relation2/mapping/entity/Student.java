package com.relation2.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double marks;
	
	@OneToMany
	private List<Laptop> laptopList;
	
	
	
	public Student(String name, double marks, List<Laptop> laptopList) {
		super();
		this.name = name;
		this.marks = marks;
		this.laptopList = (laptopList != null) ? laptopList : new ArrayList<>();
	}
	
	public Student() {
	    // Default constructor
	}
	
	public List<Laptop> getLaptopList() {
		return laptopList;
	}
	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	

}
