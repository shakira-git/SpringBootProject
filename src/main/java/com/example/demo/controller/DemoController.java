package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class DemoController {

	@Autowired
	StudentService studentService;

	@Value("${spring.application.name}")
	String applicationName;

	@RequestMapping("/test") // by default GET method
	public String testApi() {
		return "WELCOME----DEMO APP----" + applicationName;
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST) // @PostMapping
	public String addStudents(@RequestBody List<Student> student) {
		studentService.addStudents(student);
		return "Details added succesfully";
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable("id") int id) {
		Student st = studentService.getStudent(id);

		return ResponseEntity.ok(st);
	}

	@GetMapping("/student/students")
	public List<Student> getAllStudentsDetails() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return "Student removed succesfully";

	}

	@PutMapping("/student/{id}")
	public Student updateStudentDetails(@RequestBody Student student, @PathVariable("id") int id) {
		return studentService.updateStudent(student, id);
	}

	// add some update n delete methodss....

}
