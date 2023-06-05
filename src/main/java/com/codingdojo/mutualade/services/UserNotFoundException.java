package com.codingdojo.mutualade.services;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
