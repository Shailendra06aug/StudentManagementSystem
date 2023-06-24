package com.student.service;

import java.util.List;

import org.hibernate.sql.Update;

import com.student.entity.Student;

public interface StudentService {

	public List<Student> getallstudent();
	
	public Student  saveStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);
	
	public void deleteStudentById(Long id);
	
	public Student findStudentById(Long id);
	
}
