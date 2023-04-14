package com.codingdojo.mutualade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member extends User {
	
	@Column
	private String location;
	
}
