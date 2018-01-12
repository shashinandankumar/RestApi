package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nagarro.model.Student;
import com.nagarro.service.StudentSerive;
import com.nagarro.service.StudentSeriveImpl;

@Path("studentresource")
public class StudentController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getData(){
		
		StudentSerive studentservice=new StudentSeriveImpl();
		return studentservice.getData();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{studentID}")
	public Response getDataById(@PathParam("studentID") Integer sid){
		
		StudentSerive studentservice=new StudentSeriveImpl();
		if(sid==null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		System.out.println(studentservice.getDataById(sid));
		Student std=studentservice.getDataById(sid);
		if(std==null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(std).build();
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{studentID}/all")
	public Student getDataByIdall(@PathParam("studentID") Integer sid){
		
		StudentSerive studentservice=new StudentSeriveImpl();
		return studentservice.getDataById(sid);
	}
	
	@POST
	@Path("student")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Student insertData(MultivaluedMap<String, String> forms) {
		
		System.out.println(forms.getFirst("sid"));
		System.out.println(forms.getFirst("sname"));
		Student s=new Student();
		s.setSid(Integer.parseInt(forms.getFirst("sid")));
		s.setSname(forms.getFirst("sname"));
		return s;
	}
	@POST
	@Path("studentjson")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public Student insert(Student std) {
		
		System.out.println(std.getSid());
		System.out.println(std.getSname());
		
		return std;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{studentID}")
	public Response delete(@PathParam("studentID") Integer sid){
		
		StudentSerive studentservice=new StudentSeriveImpl();
		if(sid==null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		System.out.println(studentservice.getDataById(sid));
		studentservice.delete(sid);
		
		return Response.ok().build();
	}
}
