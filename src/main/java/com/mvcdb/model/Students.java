package com.mvcdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	private Long ID;
	private String name;
	private String department;
	private String classfrom;
	public Students() {
	}
	@Id
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClassfrom() {
		return classfrom;
	}
	public void setClassfrom(String classfrom) {
		this.classfrom = classfrom;
	}

}
