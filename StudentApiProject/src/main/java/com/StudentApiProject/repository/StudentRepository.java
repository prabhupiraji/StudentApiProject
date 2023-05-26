package com.StudentApiProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentApiProject.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  {



}
