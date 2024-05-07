package com.entity;

import java.util.Date;

public class Performance {
	  private String id;
	    private Employee employee1;
	    private Employee employee2;
	    private String reviewdate;
	    private int rewardpoints;
	    private FeedbackForm feedbackform;
	    private FeedbackResponse feedbackresponse;
		
		
		
		
		public Performance(String id, Employee employee1, Employee employee2, String reviewdate, int rewardpoints,
				FeedbackForm feedbackform, FeedbackResponse feedbackresponse) {
			super();
			this.id = id;
			this.employee1 = employee1;
			this.employee2 = employee2;
			this.reviewdate = reviewdate;
			this.rewardpoints = rewardpoints;
			this.feedbackform = feedbackform;
			this.feedbackresponse = feedbackresponse;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public Employee getEmployee1() {
			return employee1;
		}
		public void setEmployee1(Employee employee1) {
			this.employee1 = employee1;
		}
		public Employee getEmployee2() {
			return employee2;
		}
		public void setEmployee2(Employee employee2) {
			this.employee2 = employee2;
		}
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

		
		public String getReviewdate() {
			return reviewdate;
		}
		public void setReviewdate(String reviewdate) {
			this.reviewdate = reviewdate;
		}


	
		public int getRewardpoints() {
			return rewardpoints;
		}
		public void setRewardpoints(int rewardpoints) {
			this.rewardpoints = rewardpoints;
		}
		
	    
	    
	    
	    

}
