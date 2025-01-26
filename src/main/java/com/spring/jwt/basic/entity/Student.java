package com.spring.jwt.basic.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	
}
