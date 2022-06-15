package com.codingdojo.mutualade.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="orgAid")
public class OrgAid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required")
	private String title;
	
	@NotEmpty(message="Frequency is required")
	private String frequency;
	
	@NotEmpty(message="Description is required")
	private String description;
	
	@NotEmpty(message="Address is required")
	private String address;
	
	@Column
	private String apt;
	
	@NotEmpty(message="City is required")
	private String city;
	
	@NotEmpty(message="State is required")
	private String state;
	
	@NotEmpty(message="Zip Code is required")
	@Size(min=5, max=5, message="Zip Code must be 5 numbers long")
	private String zipCode;
	
	@Transient
	private String dateSTR;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date aidDate;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="org_id")
	private Organization org;
	
	
	@PrePersist
	protected void onCreate(){
	     this.createdAt = new Date();
	 }
	@PreUpdate
	protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
	// Constructor
	
	public OrgAid () {}
	
	// Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDateSTR() {
		return dateSTR;
	}
	public void setDateSTR(String dateSTR) {
		this.dateSTR = dateSTR;
	}
	public Date getAidDate() {
		return aidDate;
	}
	public void setAidDate(Date aidDate) {
		this.aidDate = aidDate;
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
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	
	
	

}
