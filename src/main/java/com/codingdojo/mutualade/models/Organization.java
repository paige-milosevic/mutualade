package com.codingdojo.mutualade.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="organization")

public class Organization extends User {
	
	@NotEmpty(message="Company Name is required")
	private String orgname;

	
	// Getters & Setters
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
	
}
