package com.example.webservices;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int stdId;
	private String stdName;
	private String dept;

	public Student() {
	
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Student(int stdId, String stdName, String dept) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.dept = dept;
	}
	
}
