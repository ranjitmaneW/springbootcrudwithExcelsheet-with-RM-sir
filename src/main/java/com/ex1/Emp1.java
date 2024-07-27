package com.ex1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Emp1 {
	
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
	private  String  fullname;
	private String SEmail;
	private String mobi;
	private int age;
	
	
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSEmail() {
		return SEmail;
	}
	public void setSEmail(String sEmail) {
		SEmail = sEmail;
	}
	public String getMobi() {
		return mobi;
	}
	public void setMobi(String mobi) {
		this.mobi = mobi;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp1 [id=" + id + ", fullname=" + fullname + ", SEmail=" + SEmail + ", mobi=" + mobi + ", age=" + age
				+ "]";
	}
	
	

	
	
	

}
   