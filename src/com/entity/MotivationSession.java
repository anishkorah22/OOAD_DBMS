package com.entity;

public class MotivationSession {

	private int id;
	private Performance performance;
    private Employee employee;
    private String sessionassigned;
    private FeedbackForm feedbackform;
    private FeedbackResponse feedbackresponse;
	
	
	public FeedbackForm getFeedbackform() {
		return feedbackform;
	}
	public void setFeedbackform(FeedbackForm feedbackform) {
		this.feedbackform = feedbackform;
	}
	public FeedbackResponse getFeedbackresponse() {
		return feedbackresponse;
	}
	public void setFeedbackresponse(FeedbackResponse feedbackresponse) {
		this.feedbackresponse = feedbackresponse;
	}
	public MotivationSession(int id, Performance performance, Employee employee, String sessionassigned,
			FeedbackForm feedbackform, FeedbackResponse feedbackresponse) {
		super();
		this.id = id;
		this.performance = performance;
		this.employee = employee;
		this.sessionassigned = sessionassigned;
		this.feedbackform = feedbackform;
		this.feedbackresponse = feedbackresponse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getSessionassigned() {
		return sessionassigned;
	}
	public void setSessionassigned(String sessionassigned) {
		this.sessionassigned = sessionassigned;
	}
    
}
