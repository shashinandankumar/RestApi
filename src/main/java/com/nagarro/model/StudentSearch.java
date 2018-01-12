package com.nagarro.model;

import java.util.List;

import com.nagarro.client.StudentSearchType;

public class StudentSearch {

	private int durationfrom;
	private int durationto;
	private List<Integer> sid;
	private StudentSearchType sst;
	public StudentSearchType getSst() {
		return sst;
	}
	public void setSst(StudentSearchType sst) {
		this.sst = sst;
	}
	public int getDurationfrom() {
		return durationfrom;
	}
	public void setDurationfrom(int durationfrom) {
		this.durationfrom = durationfrom;
	}
	public int getDurationto() {
		return durationto;
	}
	public void setDurationto(int durationto) {
		this.durationto = durationto;
	}
	public List<Integer> getSid() {
		return sid;
	}
	public void setSid(List<Integer> sid) {
		this.sid = sid;
	}
	
}
