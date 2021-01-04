package org.practice;

import java.util.HashMap;

import org.practice.models.Student;
import org.practice.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.practice")
@EnableWebMvc
public class ConfigurationFile {

	@Bean
	public StudentService studentService() {
		StudentService studentService = new StudentService();
		HashMap<String, Student> students = new HashMap<String, Student>();
		students.put("1", new Student.StudentBuilder()
				.setId("1")
				.setfName("Dhwani")
				.setlName("Sondhi")
				.setAddress("Ontario")
				.build());
		students.put("2", new Student.StudentBuilder()
				.setId("2")
				.setfName("Tans")
				.setlName("Singh")
				.setAddress("Ontario")
				.build());
		students.put("3", new Student.StudentBuilder()
				.setId("3")
				.setfName("Sahaj")
				.setlName("Sondhi")
				.setAddress("Vancouver")
				.build());
		studentService.setStudents(students);
		return studentService;
	}

}
