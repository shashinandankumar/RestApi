package com.nagarro.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;

public class StudentSearchClientTest {

	@Test
	public void testSearch() {
		StudentSearchClient s=new StudentSearchClient();
		List<String> searchvalues=new ArrayList<String>();
		searchvalues.add("123");
		List<Student> std=s.search("sid", searchvalues);
		
		System.out.println(std);
		assertNotNull(std);
	}
	@Test
	public void testSearchByObject() {
	
		StudentSearchClient s=new StudentSearchClient();
		
		StudentSearch studentsearch=new StudentSearch();
		List<Integer> list=new ArrayList<Integer>();
		list.add(123);
		list.add(1234);
		studentsearch.setSid(list);
		studentsearch.setDurationfrom(30);
		studentsearch.setDurationto(50);
		studentsearch.setSst(StudentSearchType.SEARCH_BY_SID);
		List<Student> std=s.searchByObject(studentsearch);
		System.out.println(std);
		assertNotNull(std);
	}
}
