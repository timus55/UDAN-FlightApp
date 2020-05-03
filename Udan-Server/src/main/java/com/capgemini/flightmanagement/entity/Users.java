package com.capgemini.flightmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="USERID")
	private Integer userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	@Min(10)
	private int age;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHONENUM")
	private long phoneNum;
	
	
	public  Users() {
		
	}


	public Users(Integer userId, String name, int age, String username, String password, long phoneNum) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.phoneNum = phoneNum;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public long getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", age=" + age + ", username=" + username + ", password="
				+ password + ", phoneNum=" + phoneNum + "]";
	}
	
	
}

