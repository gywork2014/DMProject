package com.duomei.bases.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class StudentEntity {
	
	private String student_id;
	private String student_name;
	private String student_sex;
	private Date student_birthday;
	private String class_id;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public Date getStudent_birthday() {
		return student_birthday;
	}
	public void setStudent_birthday(Date student_birthday) {
		this.student_birthday = student_birthday;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	
}
