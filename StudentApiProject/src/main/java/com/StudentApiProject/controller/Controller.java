package com.StudentApiProject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentApiProject.model.Student;
import com.StudentApiProject.service.StudentService;

@RestController
public class Controller {
	@Autowired
	StudentService service;
	
	// getting all students records from database
	@GetMapping("/getallstudentrecords")
	public  ResponseEntity  <List<Student>> getAllStudentRecords() {
		List<Student> result=service.getAllStudentRecords();
		if (result.isEmpty())
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
       return ResponseEntity.ok().body(result);

	}
	
	//saving individual record in database
	@PostMapping("/saverecord")
	ResponseEntity<Student>  saveStudent(@RequestBody Student student) {
		Student studentrecord=service.saveStudent(student);
		
		if (student !=null) {
			return new ResponseEntity <>(student,HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity <>(HttpStatus.BAD_REQUEST) ;
		}
	}
	
	//sorting the student records by pageno and size
	@GetMapping("/sortbypageno")
    public ResponseEntity<List<Student>> getPaginatedStudents(
            @RequestParam("page") int pageNumber,
            @RequestParam("size") int pageSize) {

        List<Student> allStudents = service.getAllStudentRecords();

        int totalDataSize = allStudents.size();

        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalDataSize);

        List<Student> paginatedStudents = allStudents.subList(startIndex, endIndex);

       
        return ResponseEntity.ok(paginatedStudents);
    }
	   
	 // sorting the student data using individual parameter criteria using UI
	    @GetMapping("/")
	    public List<Student> getFilteredStudents(@RequestParam(required = false) String name,
	                                             @RequestParam(required = false) Integer id,
	                                             @RequestParam(defaultValue = "1") int page,
	                                             @RequestParam(defaultValue = "10") int pageSize) {
	        // Retrieve all students
	        List<Student> allStudents = service.getAllStudentRecords();

	        // Apply filtering based on criteria
	        List<Student> filteredStudents = allStudents.stream()
	                .filter(student -> {
	                    boolean nameMatches = name == null || student.getName().contains(name);
	                    boolean idMatches = id == null || student.getId() == id;
	                    return nameMatches && idMatches;
	                })
	                .collect(Collectors.toList());

	        // Perform pagination
	        int startIndex = (page - 1) * pageSize;
	        int endIndex = Math.min(startIndex + pageSize, filteredStudents.size());
	        return filteredStudents.subList(startIndex, endIndex);
	    }
	
	
	
}
