package com.nagarro.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.nagarro.model.Student;

public class StudentClientTest {

	@Test
	public void testGet() {
		StudentClient sclient=new StudentClient();
		Student std=sclient.get(1234);
		System.out.println(std);
		assertNotNull(std);
	}
	@Test
	public void testAllGet() {
		StudentClient sclient=new StudentClient();
		List<Student> std=sclient.get();
		System.out.println(std);
		assertNotNull(std);
	}
	
	@Test//(expected=RuntimeException.class)
	public void testInsert() {
		StudentClient sclient=new StudentClient();
		Student std=new Student();
		   std.setSid(1232);
		   std.setSname("raju");
		Student std1=sclient.insert(std);
		System.out.println(std1);
		assertNotNull(std1);
	}
	@Test
	public void testdelete() {
		StudentClient sclient=new StudentClient();
		sclient.delete(123);
		
	}
}
