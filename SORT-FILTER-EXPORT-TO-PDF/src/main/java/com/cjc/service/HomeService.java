package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface HomeService {
	public int saveData(Student s);

	public List<Student> getAllStu();

	public Student getStudentById(int id);

	public List<Student> loginCheck(String uname, String pass);

	public void deleteStudent(int id);

	public void updateStudent(Student s);

	public List<Student> allSortedStu(int sortvalue);

	public List<Student> filterStudents(String keyword);
}
