package com.quiz_bank.quiz_bank.quiz;

import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
