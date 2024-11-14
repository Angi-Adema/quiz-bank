package com.quiz_bank.quiz_bank.quiz;

import java.util.List;

public class Quiz {
	
	// Attributes of the quiz.
	private String id;
	private String title;
	private String description;
	private List<Question> questions;
	
	// No argument constructor utilized for Hibernate to populate fields in the database, Spring to instantiate the object and Jackson to deserialize JSON data.
	public Quiz() {
		
	}

	public Quiz(String id, String title, String description, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", description=" + description + ", questions=" + questions
				+ "]";
	}
 
}
