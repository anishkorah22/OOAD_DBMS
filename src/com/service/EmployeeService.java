package com.service;

import java.sql.Connection;
import java.util.List;

import com.dao.MotivationSessionDAO;
import com.dao.RewardSessionDAO;
import com.entity.MotivationSession;
import com.entity.RewardSession;


public class EmployeeService {


	 private RewardSessionDAO rewardSessionDAO;
	    private MotivationSessionDAO motivationSessionDAO;

	    public EmployeeService() {
	   
	        rewardSessionDAO = new RewardSessionDAO();
	        motivationSessionDAO = new MotivationSessionDAO();
	    }

	    public void displayBestPerformer(int choice) {
	    	Connection connection=RewardSessionDAO.getConnection();
	        List<RewardSession> bestPerformers = rewardSessionDAO.getEmployeeBestPerformers(connection, choice);
	        // Display best performers
	        System.out.println("EMPLOYEE_ID \tEMPLOYEE_FNAME\tEMPLOYEE_LNAME\tFEEDBACKFORM_ID\tFEEDBACKRESPONSE_ID\tREWARD_POINTS\tREWARD_TYPE");
	        for(RewardSession rewardsession : bestPerformers)
			{
	        	
	        	System.out.println(rewardsession.getEmployee().getId()+"\t\t"+rewardsession.getEmployee().getFirstname()+"\t\t"+rewardsession.getEmployee().getSecondname()+"\t\t"+rewardsession.getFeedbackform().getId()+"\t\t"+rewardsession.getFeedbackresponse().getId()+"\t\t\t"+rewardsession.getPerformance().getRewardpoints()+"\t\t"+rewardsession.getRewardtype());
			}
	    }

	    public void displayLeastPerformer(int choice) {
	    	Connection connection=MotivationSessionDAO.getConnection();
	        List<MotivationSession> leastPerformers = motivationSessionDAO.getEmployeeLeastPerformers(connection, choice);
	        // Display least performers
	        System.out.println("EMPLOYEE_ID \tEMPLOYEE_FNAME\tEMPLOYEE_LNAME\tFEEDBACKFORM_ID\tFEEDBACKRESPONSE_ID\tREWARD_POINTS\tSESSION_ASSIGNED");
	        for(MotivationSession motivationsession : leastPerformers)
			{
	        	
	        	System.out.println(motivationsession.getEmployee().getId()+"\t\t"+motivationsession.getEmployee().getFirstname()+"\t\t"+motivationsession.getEmployee().getSecondname()+"\t\t"+motivationsession.getFeedbackform().getId()+"\t\t"+motivationsession.getFeedbackresponse().getId()+"\t\t\t"+motivationsession.getPerformance().getRewardpoints()+"\t\t"+motivationsession.getSessionassigned());
			}
	    }

	    public void displayEmployeesWithRewards(int choice) {
	    	Connection connection=MotivationSessionDAO.getConnection();
	        List<RewardSession> employeesWithRewards = rewardSessionDAO.getEmployeesWithRewards(connection,choice);
	        // Display employees with rewards
	        System.out.println("EMPLOYEE_ID \tEMPLOYEE_FNAME\tEMPLOYEE_LNAME\tFEEDBACKFORM_ID\tFEEDBACKRESPONSE_ID\tREWARD_POINTS\tREWARD_TYPE");
	        for(RewardSession rewardsession : employeesWithRewards)
			{
	        	
				System.out.println(rewardsession.getEmployee().getId()+"\t\t"+rewardsession.getEmployee().getFirstname()+"\t\t"+rewardsession.getEmployee().getSecondname()+"\t\t"+rewardsession.getFeedbackform().getId()+"\t\t"+rewardsession.getFeedbackresponse().getId()+"\t\t\t"+rewardsession.getPerformance().getRewardpoints()+"\t\t"+rewardsession.getRewardtype());
			}
	        
	    }

	    public void displayEmployeesWithMotivationSessions(int choice) {
	    	Connection connection=MotivationSessionDAO.getConnection();
	        List<MotivationSession> employeesWithMotivationSessions = motivationSessionDAO.getEmployeesWithMotivationSessions(connection,choice);
	        // Display employees with motivation sessions
	        System.out.println("EMPLOYEE_ID \tEMPLOYEE_FNAME\tEMPLOYEE_LNAME\tFEEDBACKFORM_ID\tFEEDBACKRESPONSE_ID\tREWARD_POINTS\tSESSION_ASSIGNED");
	        for(MotivationSession motivationsession : employeesWithMotivationSessions)
			{
	        	
	        	System.out.println(motivationsession.getEmployee().getId()+"\t\t"+motivationsession.getEmployee().getFirstname()+"\t\t"+motivationsession.getEmployee().getSecondname()+"\t\t"+motivationsession.getFeedbackform().getId()+"\t\t"+motivationsession.getFeedbackresponse().getId()+"\t\t\t"+motivationsession.getPerformance().getRewardpoints()+"\t\t"+motivationsession.getSessionassigned());
			}
	    }
	}
