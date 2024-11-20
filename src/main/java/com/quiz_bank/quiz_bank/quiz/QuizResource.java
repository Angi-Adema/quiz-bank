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
	
	// Create URI to retrieve a quiz by the quiz Id. URL: localhost:8080/quizzes/QuizId.
	// Correct error when enter a quizId that does not exist, extract to local variable and return quizService.retrieveQuizById(quizId).
	@RequestMapping("/quizzes/{quizId}")
	public Quiz retrieveQuizById(@PathVariable String quizId) {
		
		Quiz quiz = quizService.retrieveQuizById(quizId);
		
		// Check if quizId is null.
		if (quiz == null)
			
			// Throw correct error message if the Id does not exist.
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return quiz;
	}
	
	// PUT request to update a question by removing it and replacing it. URL: localhost:8080/quizzes/QuizId/questions
	@RequestMapping("/quizzes/{quizId}/questions")
	
	// Return a List of questions from a specific quiz.
	public List<Question> retrieveAllQuizQuestions(@PathVariable String quizId) {
		List <Question> questions = quizService.retrieveAllQuizQuestions(quizId);
		
		// Handle null questions.
		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return questions;
	}
	
	// GET request to retrieve the specific question. URL: localhost:8080/quizzes/QuizId/questions/Question#
	@RequestMapping("/quizzes/{quizId}/questions/{questionId}")
	
	public Question retrieveSpecificQuizQuestion(@PathVariable String quizId, @PathVariable String questionId) {
		
		Question question = quizService.retrieveSpecificQuizQuestion(quizId, questionId);
		
		if (question == null)
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return question;
		
	}
	
	
	
}
