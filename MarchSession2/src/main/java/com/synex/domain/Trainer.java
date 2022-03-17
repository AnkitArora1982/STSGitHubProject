package com.synex.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	private int id;
	private String name;
	private int age;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MarchEmp> marchEmp;
	
	public List<MarchEmp> getMarchEmp() {
		return marchEmp;
	}
	public void setMarchEmp(List<MarchEmp> marchEmp) {
		this.marchEmp = marchEmp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
	
}
