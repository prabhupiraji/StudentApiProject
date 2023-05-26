package com.StudentApiProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentApiProject.model.Student;
import com.StudentApiProject.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public List<Student> getAllStudentRecords() {
		return repository.findAll();
		
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

//	public Student saveStudent(Student student) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public Student saveStudent(Student student) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
