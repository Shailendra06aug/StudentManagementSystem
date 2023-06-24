package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repositry.StudentRepo;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	private StudentRepo repo;

	
//	public StudentServiceImpl(StudentRepo repo) {
//		super();
//		this.repo = repo;
//	}


	@Override
	public List<Student> getallstudent() {
		
		return repo.findAll();
				
	}


	@Override
	public Student saveStudent(Student student) {
		
	return	repo.save(student);
		
	}


	@Override
	public Student getStudentById(Long id) {
		
		return repo.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return repo.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		
		repo.deleteById(id);
	}


	@Override
	public Student findStudentById(Long id) {
		
		return repo.findById(id).get();
	}


	


	
	
	
	
}
