package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;
import com.nagarro.service.StudentSerive;
import com.nagarro.service.StudentSeriveImpl;

@Path("search/student")
public class StudentSearchContoller {
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response searchById(@QueryParam(value="sid") List<String> searchvalues){
		
		System.out.println(searchvalues);
		StudentSerive studentservice=new StudentSeriveImpl();
		List<Student> std=studentservice.searchById(searchvalues);
		
		if(std==null ||std.size()<=0) {
			Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericEntity<List<Student>>(std) {}).build();
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response searchByObject(StudentSearch studentsearch){
		
		System.out.println(studentsearch.getDurationfrom()+" "+studentsearch.getSid() );
		StudentSerive studentservice=new StudentSeriveImpl();
		List<Student> std=studentservice.findByObject(studentsearch);
		
		if(std==null ||std.size()<=0) {
			Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericEntity<List<Student>>(std) {}).build();
	}

}
