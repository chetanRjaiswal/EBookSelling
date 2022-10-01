package com.webkorps.entity;

public class User 
{
	
private int id;
private String name;
private String email;
private String role;
private String password;
private String city;
private String state;
private String pincode;

public User() {
	
}



public User(String name, String email, String role, String password, String city, String state, String pincode) {
	super();
	this.name = name;
	this.email = email;
	this.role = role;
	this.password = password;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
}



public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}



@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", password=" + password
			+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}

}
