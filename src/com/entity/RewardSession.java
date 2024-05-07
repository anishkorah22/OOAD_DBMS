package com.entity;

import java.util.Date;

public class RewardSession {

	private int id;
    private Performance performance;
    private Employee employee;
    private String rewardtype;
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
	public RewardSession(int id, Performance performance, Employee employee, String rewardtype,
			FeedbackForm feedbackform, FeedbackResponse feedbackresponse) {
		super();
		this.id = id;
		this.performance = performance;
		this.employee = employee;
		this.rewardtype = rewardtype;
		this.feedbackform = feedbackform;
		this.feedbackresponse = feedbackresponse;
	}
	public RewardSession(int id2, String firstname, String secondname, int feedbackformId, int feedbackresponseId,
			Date reviewdate, int rewardpoints, String rewardtype2) {
		// TODO Auto-generated constructor stub
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
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
    
    
    
}
