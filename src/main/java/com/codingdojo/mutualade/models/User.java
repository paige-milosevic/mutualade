package com.codingdojo.mutualade.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="First Name is required")
	protected String firstName;
	
	@NotEmpty(message="Last Name is required")
	private String lastName;
	
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email.")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=120, message="Password must be between 8 and 120 characters")
	private String password;

	@NotEmpty
	private String userType;
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	@Transient
	@NotEmpty(message="Please confirm your password")
	@Size(min=8, max=120, message="Password must be between 8 and 120 characters")
	private String confirm;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
	     this.createdAt = new Date();
	 }
	@PreUpdate
	protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
	// Constructor
	
	public User () {}
	
	// Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	
	
	
	
}
