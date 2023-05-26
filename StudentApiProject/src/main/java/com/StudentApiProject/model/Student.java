package com.StudentApiProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private double marks;
//	private int rolNo;
	private String schoolName;
	public Student() {
	
	}
	public Student(int id, String name, double marks, String schoolName) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		
		this.schoolName = schoolName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
