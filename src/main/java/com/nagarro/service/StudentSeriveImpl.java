package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;
import com.nagarro.repository.StudentRepository;
import com.nagarro.repository.StudentRepositoryImpl;

public class StudentSeriveImpl implements StudentSerive {


	public List<Student> getData(){
	StudentRepository studentrepositry=new StudentRepositoryImpl();
	
	return studentrepositry.getData();
	}

	@Override
	public Student getDataById(Integer sid) {
		// TODO Auto-generated method stub
		StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		return studentrepositry.getDataById(sid);
	}

	@Override
	public void delete(Integer sid) {
		// TODO Auto-generated method stub
      StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		studentrepositry.delete(sid);
	}
	
	public List<Student> searchById(List<String> searchvalues) {
		StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		return studentrepositry.searchById(searchvalues);
		}

	@Override
	public List<Student> findByObject(StudentSearch studentsearch) {
     
		StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		return studentrepositry.findByObject(studentsearch);
	}
}
