package com.nagarro.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	
	private int sid;
	
	private String sname;
	
	
	public int getSid() {
		return sid;
	}
	@XmlElement(name="Id")
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
