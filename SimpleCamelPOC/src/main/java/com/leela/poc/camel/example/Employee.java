package com.leela.poc.camel.example;

public class Employee {
	
	String name;
	String dept;
	
	public Employee() {
		super();
	}

	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void display() {
		System.out.println(" Welcome to "+ dept+ " department from "+ name);
	}
	
	public void hello() {
		
		System.out.println("Hello from employee");
		
	}

}
