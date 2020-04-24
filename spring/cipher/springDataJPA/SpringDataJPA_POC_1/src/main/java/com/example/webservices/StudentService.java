package com.example.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private List<Student> students = new ArrayList<>(Arrays.asList(
					new Student(1, "Jason", "HR"),
					new Student(2, "Betty", "DB"),
					new Student(3, "Archi", "IT")
			));
	public List<Student> getAllStudents() {
		return students;
	}
	public Student getStudentById(int id) {
		for(Student s:students) {
			if(s.getStdId() == id) {
				System.out.print("\n"+s);
				return s;
			}
		}
		return null;
	}
	public void addStudent(Student student) {
		students.add(student);
	}

	public void modifyStudent(Student student, int id) {
		for(int i=0; i<students.size(); i++) {
			if(id == students.get(i).getStdId()) {
				students.set(i, student);
			}
		}
	}
	public void deleteStudent(int id) {
		for(Student s:students) {
			if(s.getStdId() == id) {
				students.remove(s);
			}
		}
	}
}
