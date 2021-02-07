package com.cjc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cjc.model.Student;
import com.cjc.repository.HomeRepository;
import com.cjc.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeRepository hr;

	@Override
	public int saveData(Student s) {
		Student byId = getStudentById(s.getId());
		if (byId == null) {
			hr.save(s);
			return s.getId();
		}
		else {
			return 0;
		}
	}

	@Override
	public List<Student> getAllStu() {
		return (List<Student>) hr.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> byId = hr.findById(id);

		if (byId.isEmpty()) {
			return null;
		}
		else {
			return byId.get();
		}
	}

	@Override
	public List<Student> loginCheck(String uname, String pass) {
		if (uname.equals("admin") && pass.equals("admin")) {
			return getAllStu();
		}
		else {
			return hr.findByUnameAndPass(uname, pass);
		}
	}

	@Override
	public void deleteStudent(int id) {
		hr.deleteById(id);
	}

	@Override
	public void updateStudent(Student s) {
		hr.save(s);

	}

	@Override
	public List<Student> allSortedStu(int sortvalue) {
		switch (sortvalue) {
		case 1:
			// return hr.findAllAndSort(Sort.by("id").ascending());
			// return hr.findAllAndSort(Sort.sort(Student.class)); //primary key sort
			return hr.findAllAndSort(Sort.by(Direction.ASC, "id"));
		case 2:
			return hr.findAllAndSort(Sort.by("id").descending());
		case 3:
			return hr.findAllAndSort(Sort.by("name").ascending());
		case 4:
			return hr.findAllAndSort(Sort.by("name").descending());
		case 5:
			return hr.findAllAndSort(Sort.by("address.pincode").ascending());
		case 6:
			return hr.findAllAndSort(Sort.by("address.pincode").descending());
		case 7:
			return hr.findAllAndSort(Sort.by("address.areaname").ascending());
		case 8:
			return hr.findAllAndSort(Sort.by("address.areaname").descending());
		case 9:
			return hr.findAllAndSort(Sort.by("address.cityname").ascending());
		case 10:
			return hr.findAllAndSort(Sort.by("address.cityname").descending());
		default:
			return null;
		}
	}

	@Override
	public List<Student> filterStudents(String keyword) {

		if (keyword != null) {

			return hr.findAll(keyword);

		}
		else {
			return getAllStu();
		}

	}
}
