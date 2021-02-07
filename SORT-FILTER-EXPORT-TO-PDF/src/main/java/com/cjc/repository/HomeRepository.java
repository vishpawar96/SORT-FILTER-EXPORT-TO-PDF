package com.cjc.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer> {

	List<Student> findByUnameAndPass(String uname, String pass);

	@Query("from Student")
	List<Student> findAllAndSort(Sort sort);

	@Query("select s from Student s where concat (s.id, s.name, s.uname) LIKE %?1%")
	public List<Student> findAll(String keyword);

}
