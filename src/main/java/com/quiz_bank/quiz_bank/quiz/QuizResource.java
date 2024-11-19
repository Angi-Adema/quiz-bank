package com.quiz_bank.quiz_bank.quiz;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// Spring REST API controller.
@RestController
public class QuizResource {

	// Make use of QuizService.
	private QuizService quizService;

	// Constructor for constructor injection using Spring.
	public QuizResource(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	
	// Map URI /quizzes and when visited returns all the quizzes. Created retrieveAllQuizzes() in QuizService.java. Spring @RequestMapping.
	@RequestMapping("/quizzes")
	public List<Quiz> retrieveAllQuizzes() {
		return quizService.retrieveAllQuizzes();
	}
	
	// Create URI to retrieve a quiz by the quiz Id. URL: localhost:8080/quizzes/quizId.
	// Correct error when enter a quizId that does not exist, extract to local variable and return quizService.retrieveQuizById(quizId).
	@RequestMapping("/quizzes/{quizId}")
	public Quiz retrieveQuizById(@PathVariable String quizId) {
		
		Quiz quiz = quizService.retrieveQuizById(quizId);
		
		// Check if quizId is null.
		if (quiz == null)
			
			// Throw correct error message if the Id does not exist.
			throw new ResponseStatusException(HttpStatus.NOT_EXTENDED);
		
		return quiz;
	}
	
	
	
}
