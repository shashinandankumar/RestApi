package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;

public interface StudentRepository {

	List<Student> getData();

	Student getDataById(Integer sid);

	void delete(Integer sid);

	List<Student> searchById(List<String> searchvalues);

	List<Student> findByObject(StudentSearch studentsearch);

	

}