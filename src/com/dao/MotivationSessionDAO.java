package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;
import com.entity.FeedbackForm;
import com.entity.FeedbackResponse;
import com.entity.MotivationSession;
import com.entity.Performance;


public class MotivationSessionDAO {
	
	public static Connection getConnection() {
		String connectionString ="jdbc:mysql://localhost:3306/employeemotivation?useSSL=false";
		String userName ="root";
		String password ="1234";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public List<MotivationSession> getEmployeeLeastPerformers(Connection connection, int choice) {
        ArrayList<MotivationSession> leastPerformers = new ArrayList<>();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        preparedStatement = connection.prepareStatement("SELECT distinct e.id, e.firstname, e.secondname,ms.feedbackform_id,ms.feedbackresponse_id, p.rewardpoints, ms.sessionassigned FROM employee e INNER JOIN performance p ON e.id=p.pointassignedto INNER JOIN motivationsession ms ON ms.assignedto = p.pointassignedto WHERE p.rewardpoints = (SELECT MIN(rewardpoints) FROM performance);");
	        
	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            // Populate RewardSession object here
	        	String id = resultSet.getString(1);
	            String firstname = resultSet.getString(2);
	            String secondname = resultSet.getString(3);
	            String feedbackformId = resultSet.getString(4);
	            String feedbackresponseId = resultSet.getString(5);
	            int rewardPoint=resultSet.getInt(6);
	            String sessionassigned = resultSet.getString(7);
	            
	            Employee employee1=new Employee(null,null,null,987876876,null);
	            Employee employee2=new Employee(id,firstname,secondname,987876876,null);
	            FeedbackForm feedbackForm=new FeedbackForm(feedbackformId,null,null,null,null,null);
	            FeedbackResponse feedbackResponse=new FeedbackResponse(feedbackresponseId,feedbackForm,employee2,0,0,0,0,0); 
	            Performance performance =new Performance(null,employee1,employee2,"2024-05-01",rewardPoint,feedbackForm,feedbackResponse);
	            MotivationSession motivationSession=new MotivationSession(0,performance,employee2,sessionassigned,feedbackForm,feedbackResponse);	            
	            leastPerformers.add(motivationSession);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return leastPerformers;
	}

    // Similar methods for other queries...
    public static ArrayList<MotivationSession> getEmployeesWithMotivationSessions(Connection connection,int choice) {
    	
        ArrayList<MotivationSession> employeesWithMotivationSessions = new ArrayList<>();
       
    	    PreparedStatement preparedStatement = null;
    	    ResultSet resultSet = null;
    	    try {
    	        String query = "SELECT distinct e.id,e.firstname,e.secondname,ms.feedbackform_id,ms.feedbackresponse_id,p.rewardpoints,ms.sessionassigned FROM employee e INNER JOIN motivationsession ms ON e.id = ms.assignedto inner join performance p on p.pointassignedto=ms.assignedto;";
    	        preparedStatement = connection.prepareStatement(query);
    	        resultSet = preparedStatement.executeQuery();
    	        while (resultSet.next()) {
    	            // Populate RewardSession object here
    	            String id = resultSet.getString(1);
    	            String firstname = resultSet.getString(2);
    	            String secondname = resultSet.getString(3);
    	            String feedbackformId = resultSet.getString(4);
    	            String feedbackresponseId = resultSet.getString(5);
    	            int rewardPoint=resultSet.getInt(6);
    	            String sessionassigned = resultSet.getString(7);
    	            
    	            Employee employee1=new Employee(null,null,null,987876876,null);
    	            Employee employee2=new Employee(id,firstname,secondname,987876876,null);
    	            FeedbackForm feedbackForm=new FeedbackForm(feedbackformId,null,null,null,null,null);
    	            FeedbackResponse feedbackResponse=new FeedbackResponse(feedbackresponseId,feedbackForm,employee2,0,0,0,0,0); 
    	            Performance performance =new Performance(null,employee1,employee2,"2024-05-01",rewardPoint,feedbackForm,feedbackResponse);
    	            MotivationSession motivationSession=new MotivationSession(0,performance,employee2,sessionassigned,feedbackForm,feedbackResponse);	            
    	            employeesWithMotivationSessions.add(motivationSession);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } 
    	    
    	    return employeesWithMotivationSessions;
    	}
}