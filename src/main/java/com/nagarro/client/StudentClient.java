package com.nagarro.client;



import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nagarro.model.Student;

public class StudentClient {
	
	Client client;
	StudentClient(){
	
		 client=ClientBuilder.newClient();
	}
  
	public Student get(int id) {
		WebTarget target=client.target("http://localhost:8080/restdemo/rest/");
		
	    Response response= target.path("studentresource/"+id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
	    if(response.getStatus()!=200) {
	    	throw new RuntimeException(response.getStatus()+":there was error on server");
	    }
	    System.out.println(response);
	    return response.readEntity(Student.class);
	}
	public List<Student> get() {
		WebTarget target=client.target("http://localhost:8080/restdemo/rest/");
		
		return target.path("studentresource/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Student>>() {});
		
	}

	public Student insert(Student std) {
		// TODO Auto-generated method stub
        WebTarget target=client.target("http://localhost:8080/restdemo/rest/");
		
	    Response response= target.path("studentresource/studentjson").request(MediaType.APPLICATION_JSON).post(Entity.entity(std, MediaType.APPLICATION_JSON));
		
	    if(response.getStatus()!=200) {
	    	throw new RuntimeException(response.getStatus()+":there was error on server");
	    }
	    System.out.println(response);
	    return response.readEntity(Student.class);
		
		  
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
        WebTarget target=client.target("http://localhost:8080/restdemo/rest/");
		
	    Response response= target.path("studentresource/"+id).request(MediaType.APPLICATION_JSON).delete();
		
	    if(response.getStatus()!=200) {
	    	throw new RuntimeException(response.getStatus()+":there was error on server");
	    }
	    System.out.println(response);
	    
	}

}
