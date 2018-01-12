package com.nagarro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;

public class StudentRepositoryImpl implements StudentRepository {

	
	
	/* (non-Javadoc)
	 * @see com.nagarro.repository.StudentRepository#getData()
	 */
	List<Student> students;
	@Override
	public List<Student> getData(){
	
	 students=new ArrayList<Student>();
	Student student1=new Student();
	student1.setSid(123);
	student1.setSname("shashi");
	
	Student student2=new Student();
	student2.setSid(1234);
	student2.setSname("Kumar");
	
	students.add(student1);
	students.add(student2);
    return students;
	}


	public Student getDataById(Integer sid) {
		// TODO Auto-generated method stub
		StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		students= studentrepositry.getData();
		Student stdrec = 
			    students
			    .stream()
			    .filter(p-> p.getSid()==sid)
			    .findAny().get();
		
		return stdrec;
	}


	public void delete(Integer sid) {
		// TODO Auto-generated method stub
StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		students= studentrepositry.getData();
		Student stdrec = 
			    students
			    .stream()
			    .filter(p-> p.getSid()==sid)
			    .findAny().get();
	}


	@Override
	public List<Student> searchById(List<String> searchvalues) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//select *from student where sid in(?,?,?)
StudentRepository studentrepositry=new StudentRepositoryImpl();
		
		students= studentrepositry.getData();
//		Student stdrec = 
//			    students
//			    .stream()
//			    .filter(p-> p.getSid()==Integer.parseInt(searchvalues.get(0)))
//			    .findAny().get();
		return students;
	}


	@Override
	public List<Student> findByObject(StudentSearch studentsearch) {
		// TODO Auto-generated method stub
		StudentRepository studentrepositry=new StudentRepositoryImpl();
		System.out.println(studentsearch.getDurationfrom());
		System.out.println(studentsearch.getSst());
		students= studentrepositry.getData();
		return students;
	}
	
}
