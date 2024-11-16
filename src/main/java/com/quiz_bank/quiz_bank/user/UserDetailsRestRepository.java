package com.quiz_bank.quiz_bank.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {

	// Search users by role.
	List<UserDetails> findByRole(String role);
}
