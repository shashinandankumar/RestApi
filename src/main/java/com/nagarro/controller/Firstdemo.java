package com.nagarro.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("firstdemo")
public class Firstdemo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData() {
		
		return "data";
	}
}
