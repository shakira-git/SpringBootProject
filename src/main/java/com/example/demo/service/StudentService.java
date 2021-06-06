package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	public void addStudents(List<Student> student);

	public Student getStudent(int id);
	
	public List<Student> getAllStudents();
	
	public void deleteStudent(int id);
	
	public Student updateStudent(Student student, int id);

}
