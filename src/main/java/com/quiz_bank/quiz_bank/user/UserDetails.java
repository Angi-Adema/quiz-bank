package com.quiz_bank.quiz_bank.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Manage by JPA so use @Entity.
@Entity
public class UserDetails {
	
	// Have Spring manage attributes of the user and enter @Id and @GeneratedValue.
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String role;
	
	// Populate user details in UserDetailsCommandLineRunner.java.
	public UserDetails() {
		
	}

	public UserDetails(String firstName, String lastName, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}
	
}
