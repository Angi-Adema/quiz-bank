package com.quiz_bank.quiz_bank.quiz;

import java.util.List;

public class Question {

	// Attributes of the question.
	private String id;
	private String description;
	private List<String> options;
	private String correctAnswer;
	
	public Question() {
		
	}

	public Question(String id, String description, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.description = description;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public String getId() {
		return id;
	}
	
	// Add setId() to generate and set the new Id for each question.
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", options=" + options + ", correctAnswer="
				+ correctAnswer + "]";
	}
	
}
