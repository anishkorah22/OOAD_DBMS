package com.entity;

public class Employee {
	private String id;
    private String firstname;
    private String secondname;
    private long phno;
    private String email;
    
    
    
	public Employee(String id, String firstname, String secondname, long phno, String email) {
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.phno = phno;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    

}
