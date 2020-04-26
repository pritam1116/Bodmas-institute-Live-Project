/**
 * 
 */
package com.bodmas.model;

import java.util.Date;

/**
 * @author Pritam Sinha
 *
 */
public class StudentRegister {
	
	private String first_name;
	private String last_name;
	private String user_name;
	private String password;
	private String new_password;
	private String email;
	private String gender;
	private Date date_of_birth;
	private String mobile;
	private String	address;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

	public StudentRegister(String first_name, String last_name, String user_name, String password, String new_password,
			String email, String gender, Date date_of_birth, String mobile, String address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.password = password;
		this.new_password = new_password;
		this.email = email;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.mobile = mobile;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentRegister [first_name=" + first_name + ", last_name=" + last_name + ", user_name=" + user_name
				+ ", password=" + password + ", new_password=" + new_password + ", email=" + email + ", gender="
				+ gender + ", date_of_birth=" + date_of_birth + ", mobile=" + mobile + ", address=" + address + "]";
	}
	
	

	
	
}
