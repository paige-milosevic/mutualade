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

@Entity
@Table(name="aidRequest")
public class AidRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required")
	private String title;
	
	@NotEmpty(message="Urgency is required")
	private String urgency;
	
	@NotEmpty(message="Description is required")
	private String description;
	
	@NotEmpty(message="Request Type is required")
	private String privacy;
	
	@Column
	private String venmo;
	
	@Column
	private String instagram;
	
	@Transient
	private String dateSTR;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date aidDate;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Member member;
	
	
	@PrePersist
	protected void onCreate(){
	     this.createdAt = new Date();
	 }
	@PreUpdate
	protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
	// Constructor
	
	public AidRequest () {}
	
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
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getVenmo() {
		return venmo;
	}
	public void setVenmo(String venmo) {
		this.venmo = venmo;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
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
	public Date getAidDate() {
		return aidDate;
	}
	public void setAidDate(Date aidDate) {
		this.aidDate = aidDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getDateSTR() {
		return dateSTR;
	}
	public void setDateSTR(String dateSTR) {
		this.dateSTR = dateSTR;
	}
	
	
	
}
