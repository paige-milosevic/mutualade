package com.codingdojo.mutualade.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member extends User {
	
	@Column
	private String location;
	
	@OneToMany(mappedBy="member", fetch = FetchType.LAZY)
	private List<AidRequest> aidReq;
	
	public List<AidRequest> getAidReq() {
		return aidReq;
	}
	public void setAidReq(List<AidRequest> aidReq) {
		this.aidReq = aidReq;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	
}
