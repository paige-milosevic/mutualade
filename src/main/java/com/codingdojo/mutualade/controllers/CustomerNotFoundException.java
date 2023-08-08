package com.codingdojo.mutualade.controllers;

public class CustomerNotFoundException extends Exception {
	
	public CustomerNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
