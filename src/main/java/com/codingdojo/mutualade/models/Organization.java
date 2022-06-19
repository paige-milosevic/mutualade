package com.codingdojo.mutualade.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="organization")
public class Organization extends User {
	
	@NotEmpty(message="Company Name is required")
	private String orgName;
	
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
