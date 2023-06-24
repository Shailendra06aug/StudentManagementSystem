package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.repositry.StudentRepo;

@SpringBootApplication
public class StdenntManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StdenntManagementSystemApplication.class, args);
		
		
		
		
	}

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
//		Student student = new Student("pankaj","kumar","panakj@gmail.com");
//		studentRepo.save(student);
//		Student student1 = new Student("hirekant","singh","hirekant@gmail.com");
//		studentRepo.save(student1);
		
		
		
	}

}
