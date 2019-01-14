package com.george.cloudclient.entity;

public class User {
	
	private Long id;

	private String uName;
	
	private String uSex;

	public User(){
		
	}
	
	public User(String uName,String uSex){
		this.uName = uName;
		this.uSex = uSex;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", uSex=" + uSex + "]";
	}
}
