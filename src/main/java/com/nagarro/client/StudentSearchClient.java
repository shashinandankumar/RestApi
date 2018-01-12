package com.nagarro.client;

import java.lang.annotation.Target;
import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.nagarro.model.Student;
import com.nagarro.model.StudentSearch;

public class StudentSearchClient {

	Client client;
	StudentSearchClient(){
	
		 client=ClientBuilder.newClient();
	}
	
	public List<Student> search(String param,List<String> searchvalues){
		
		URI uri=UriBuilder.fromUri("http://localhost:8080/restdemo/rest/").
				path("search/student").queryParam(param, searchvalues)
				//.queryParam(name, values) add multiple queryparam
				.build();
		
		WebTarget target=client.target(uri);
		 
		List<Student> response= target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Student>>() {});
		System.out.println(response);
		
		
		return response;
		
		
	}

	public List<Student> searchByObject(StudentSearch studentsearch) {
		
		URI uri=UriBuilder.fromUri("http://localhost:8080/restdemo/rest/").
				path("search/student")
				.build();
		WebTarget target=client.target(uri);
		 
		Response response= target.request(MediaType.APPLICATION_JSON).post(Entity.entity(studentsearch, MediaType.APPLICATION_JSON));
		System.out.println(response);
		if(response.getStatus()!=200) {
			throw new RuntimeException(response.getStatus()+"there was Eroor in server");
		}
		
		return response.readEntity(new GenericType<List<Student>>() {});
		
	}

	
}
