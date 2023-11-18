package com.example.apex.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@Builder
public class Customer {
	
	@Id
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;


}
