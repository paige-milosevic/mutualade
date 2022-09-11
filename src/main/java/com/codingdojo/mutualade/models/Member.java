package com.codingdojo.mutualade.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue(value = "COMMUNITY_MEMBER")
public class Member extends User {
	
	@Column
	private String location;
	
	
	@OneToMany(mappedBy="member", fetch = FetchType.LAZY)
	private List<AidRequest> aidReq;
	
	// Constructor
	
	public Member() {};
	
	public Member(String location) {
		this.location = location;
	}
	
	// Getters and Setter

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	
	
	
	
}
