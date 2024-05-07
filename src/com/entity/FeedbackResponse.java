package com.entity;

public class FeedbackResponse {
	
	private String id;
    private FeedbackForm feedbackform;
    private Employee employee;
    private int firstResponse;
    private int secondResponse;
    private int thirdResponse;
    private int forthResponse;
    private int fifthResponse;
	
    
	
	public FeedbackResponse(String id, FeedbackForm feedbackform, Employee employee, int firstResponse,
			int secondResponse, int thirdResponse, int forthResponse, int fifthResponse) {
		super();
		this.id = id;
		this.feedbackform = feedbackform;
		this.employee = employee;
		this.firstResponse = firstResponse;
		this.secondResponse = secondResponse;
		this.thirdResponse = thirdResponse;
		this.forthResponse = forthResponse;
		this.fifthResponse = fifthResponse;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public FeedbackForm getFeedbackform() {
		return feedbackform;
	}
	public void setFeedbackform(FeedbackForm feedbackform) {
		this.feedbackform = feedbackform;
	}
	public int getFirstResponse() {
		return firstResponse;
	}
	public void setFirstResponse(int firstResponse) {
		this.firstResponse = firstResponse;
	}
	public int getSecondResponse() {
		return secondResponse;
	}
	public void setSecondResponse(int secondResponse) {
		this.secondResponse = secondResponse;
	}
	public int getThirdResponse() {
		return thirdResponse;
	}
	public void setThirdResponse(int thirdResponse) {
		this.thirdResponse = thirdResponse;
	}
	public int getForthResponse() {
		return forthResponse;
	}
	public void setForthResponse(int forthResponse) {
		this.forthResponse = forthResponse;
	}
	public int getFifthResponse() {
		return fifthResponse;
	}
	public void setFifthResponse(int fifthResponse) {
		this.fifthResponse = fifthResponse;
	}
    
    

}
