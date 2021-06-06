package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

//	List<Student> studentList = new ArrayList<Student>();

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void addStudents(List<Student> student) {
		// studentList.addAll(student);
		
		studentRepository.saveAll(student);
	}

	@Override
	public Student getStudent(int id) {
//		return studentList.stream().filter(student -> student.getId().equals(id)).findAny()
//				.orElseThrow(() -> new RuntimeException("Student not present"));

		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not present"));
	}

	@Override
	public List<Student> getAllStudents() {
		//return studentList;
		
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		//studentList.removeIf(student -> student.getId().equals(id));
		
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student, int id) {

//		Student st = studentList.stream().filter(stu -> stu.getId().equals(id)).findAny().get();
//		st.setGrade(student.getGrade());
//		studentList.add(st);
		
		Student st = studentRepository.findById(id).get();
		st.setGrade(student.getGrade());
		return studentRepository.save(student);

	}

}
