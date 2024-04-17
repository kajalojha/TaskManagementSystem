package com.classroom.Classroom;

import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ClassroomApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClassroomApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		// for single user
		Student student1 = new Student();
		student1.setStudentId(101L);
		student1.setName("kajal");
		student1.setPassword("123");
		Student student2 = studentRepository.save(student1);
		System.out.println("saved successfull..");
//		Student student = new Student();
//		student1.setName("kajal");
//		student1.setPassword("123");
////
//		Student student2 = new Student();
//		student2.setName("kajall");
//		student2.setPassword("1234");
//		List<Student> students = List.of(student1,student2);
//		Iterable<Student> result = studentRepository.saveAll(students);
//		result.forEach(student -> {
//			System.out.println(students);
//		});
		System.out.println("done");

}



}
