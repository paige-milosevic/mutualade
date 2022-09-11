package com.codingdojo.mutualade.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue(value = "ORGANIZATION")
public class Organization extends User {
	
	@NotEmpty(message="Company Name is required")
	private String orgName;
	
	@Column
	private String descriptor = "ORGANIZATION";
	
	@OneToMany(mappedBy="org", fetch = FetchType.LAZY)
	private List<OrgAid> orgAid;

	
	// Getters & Setters
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgname) {
		this.orgName = orgname;
	}

	public List<OrgAid> getOrgAid() {
		return orgAid;
	}

	public void setOrgAid(List<OrgAid> orgAid) {
		this.orgAid = orgAid;
	}
	
	
	
}
