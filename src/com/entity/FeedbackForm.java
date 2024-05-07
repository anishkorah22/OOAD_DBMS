package com.entity;

public class FeedbackForm {

	private String id;
    private String firstQuestion;
    private String secondQuestion;
    private String thirdQuestion;
    private String forthQuestion;
    private String fifthQuestion;
    
    
    
	public FeedbackForm(String id, String firstQuestion, String secondQuestion, String thirdQuestion,
			String forthQuestion, String fifthQuestion) {
		super();
		this.id = id;
		this.firstQuestion = firstQuestion;
		this.secondQuestion = secondQuestion;
		this.thirdQuestion = thirdQuestion;
		this.forthQuestion = forthQuestion;
		this.fifthQuestion = fifthQuestion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstQuestion() {
		return firstQuestion;
	}
	public void setFirstQuestion(String firstQuestion) {
		this.firstQuestion = firstQuestion;
	}
	public String getSecondQuestion() {
		return secondQuestion;
	}
	public void setSecondQuestion(String secondQuestion) {
		this.secondQuestion = secondQuestion;
	}
	public String getThirdQuestion() {
		return thirdQuestion;
	}
	public void setThirdQuestion(String thirdQuestion) {
		this.thirdQuestion = thirdQuestion;
	}
	public String getForthQuestion() {
		return forthQuestion;
	}
	public void setForthQuestion(String forthQuestion) {
		this.forthQuestion = forthQuestion;
	}
	public String getFifthQuestion() {
		return fifthQuestion;
	}
	public void setFifthQuestion(String fifthQuestion) {
		this.fifthQuestion = fifthQuestion;
	}
    
	
}
