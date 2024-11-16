package com.quiz_bank.quiz_bank.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Spring to manage this so use @Component.
@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
	
	// Implement logger.
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Make use of the UserDetailsRepository.
	private UserDetailsRepository repository;
	
	// Utilize constructor injection.
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		// Insert new users.
		repository.save(new UserDetails("Angi", "Adema", "Dev"));
		repository.save(new UserDetails("Paul", "Russell", "Applicant"));
		repository.save(new UserDetails("Jay", "Mascarenas", "Manager"));
		
		// Print users with specific role.
		List<UserDetails> users = repository.findByRole("Dev");
		
		// Do something with each user, log them for now.
		users.forEach(user -> logger.info(user.toString()));
	}
}
