package com.quiz_bank.quiz_bank.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

// Spring to manage this component so use @Service.
@Service
public class QuizService {

	// Create a static list of all the quiz details. Update List when operations are performed.
	private static List<Quiz> quizzes = new ArrayList<>();
	
	// Initialize with test data.
	static {
		
		// Quiz 1 with four questions (JavaScript).
		Question question1 = new Question("Question1", "What is JavaScript primarily used for?", 
				Arrays.asList("A. Styling web pages", "B. Adding interactivity to web pages", "C. Creating databases", "D. Writing server-side scripts"), "B. Adding interactivity to web pages");
		Question question2 = new Question("Question2", "Which of the following is the correct way to declare a variable in JavaScript?", 
				Arrays.asList("A. var myVariable = 10;", "B. int myVariable = 10;", "C. let myVariable = 10;", "D. Both A and B"), "D. Both A and C");
		Question question3 = new Question("Question3", "What does 'typeof' operator do in JavaScript?", 
				Arrays.asList("A. Checks the type of an object or variable", "B. Declares a new variable", "C. Converts a string to a number", "D. None of the above"), "A. Checks the type of an object or variable");
		Question question4 = new Question("Question4", "What is the output of console.log(2 + '2');?", 
				Arrays.asList("A. 22", "B. 4", "C. Error", "D. Undefined"), "A. 22");
		
		// Put questions into a list.
		List<Question> questionsForQuiz1 = new ArrayList<>(Arrays.asList(question1, question2, question3, question4));
		
		// Initialize quiz1
		Quiz quiz1 = new Quiz("Quiz1", "JavaScript Quiz", "JavaScript quiz for interviewees", questionsForQuiz1);
		
		
		// Quiz 2 with four questions (Python).
		Question question5 = new Question("Question5", "What is Python primarily used for?", 
				Arrays.asList("A. Mobile application development", "B. Web development, data analysis, and automation", "C. Gaming only", "D. Creating operating systems"), "B. Web development, data analysis, and automation");
		Question question6 = new Question("Question6", "Which of the following is the correct way to print a message in Python?", 
				Arrays.asList("A. echo 'Hello, World!'", "B. System.out.println('Hello, World!')", "C. print('Hello, World!')", "D. console.log('Hello, World!')"), "C. print('Hello, World!')");
		Question question7 = new Question("Question7", "Which of the following is a valid variable name in Python?", 
				Arrays.asList("A. 2myVar", "B. my-var", "C. my_var", "D. my var"), "C. my_var");
		Question question8 = new Question("Question8", "What is the data type of the following object in Pyton? my_list = [1, 2, 3, 4]", 
				Arrays.asList("A. Tuple", "B. Set", "C. List", "D. Dictionary"), "C. List");
		
		// Put questions into a list.
		List<Question> questionsForQuiz2 = new ArrayList<>(Arrays.asList(question5, question6, question7, question8));
		
		// Initialize quiz2
		Quiz quiz2 = new Quiz("Quiz2", "Python Quiz", "Python quiz for interviewees", questionsForQuiz2);
		
		
		// Quiz 3 with four questions (Java).
		Question question9 = new Question("Question9", "Which of the following is a valid Java keyword?", 
				Arrays.asList("A. static", "B. public", "C. class", "D. All of the above"), "D. All of the above");
		Question question10 = new Question("Question10", "What is the extension of a compiled Java file?", 
				Arrays.asList("A. .java", "B. .class", "C. .javac", "D. .byte"), "B. .class");
		Question question11 = new Question("Question11", "Which method is the entry point of a Java application?", 
				Arrays.asList("A. start()", "B. run()", "C. main()", "D. execute()"), "C. main()");
		Question question12 = new Question("Question12", "What is the size of an int in Java?", 
				Arrays.asList("A. 8 bits", "B. 16 bits", "C. 32 bits", "D. 64 bits"), "C. 32 bits");
		
		// Put questions into a list.
		List<Question> questionsForQuiz3 = new ArrayList<>(Arrays.asList(question9, question10, question11, question12));
		
		// Initialize quiz3
		Quiz quiz3 = new Quiz("Quiz3", "Java Quiz", "Java quiz for interviewees", questionsForQuiz3);
		
		// Add all quizzes to the list.
		quizzes.add(quiz1);
		quizzes.add(quiz2);
		quizzes.add(quiz3);
		
	}
	
	// GET request to return all quizzes.
	public List<Quiz> retrieveAllQuizzes() {
		return quizzes;
	}
	
	// GET request to retrieve quiz by Id.
	public Quiz retrieveQuizById(String quizId) {
		Predicate<? super Quiz> predicate = quiz -> quiz.getId().equals(quizId);
		Optional<Quiz> optionalQuiz = quizzes.stream().filter(predicate).findFirst();
		
		if(optionalQuiz.isEmpty()) return null;
		
		return optionalQuiz.get();
	}
	
	// GET request to retrieve all quiz questions.
	public List<Question> retrieveAllQuizQuestions(String quizId) {
		Quiz quiz = retrieveQuizById(quizId);
		
		if (quiz == null) return null;
		
		return quiz.getQuestions();
	}
	
	// GET request to retrieve a specific quiz question.
	public Question retrieveSpecificQuizQuestion(String quizId, String questionId) {
		List<Question> quizQuestions = retrieveAllQuizQuestions(quizId);
		
		if (quizQuestions == null) return null;
		
		Optional<Question> optionalQuestion = quizQuestions.stream().filter(q -> q.getId().equalsIgnoreCase(questionId)).findFirst();
		
		if (optionalQuestion.isEmpty()) return null;
		
		return optionalQuestion.get();
	}
	
}
