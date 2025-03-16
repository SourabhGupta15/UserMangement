package com.newgen.user.model;

public class User {
	
	private Integer id;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User() {
		super();
	}

}
