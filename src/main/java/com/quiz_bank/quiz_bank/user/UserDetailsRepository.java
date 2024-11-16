package com.quiz_bank.quiz_bank.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface to handle user details such as add, delete, update users.
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	// Search users by role.
	List<UserDetails> findByRole(String role);
}
