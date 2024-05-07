package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.entity.Employee;
import com.entity.FeedbackForm;
import com.entity.FeedbackResponse;
import com.entity.Performance;
import com.entity.RewardSession;
public class RewardSessionDAO {
	
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

	public static ArrayList<RewardSession> getEmployeeBestPerformers(Connection connection, int choice) {
	    ArrayList<RewardSession> bestPerformers = new ArrayList<>();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        preparedStatement = connection.prepareStatement("SELECT distinct e.id, e.firstname, e.secondname,rs.feedbackform_id,rs.feedbackresponse_id,p.rewardpoints, rs.rewardtype FROM employee e INNER JOIN performance p ON e.id = p.pointassignedto INNER JOIN rewardsession rs ON rs.assignedto = p.pointassignedto WHERE p.rewardpoints = (SELECT MAX(rewardpoints) FROM performance);");
	        
	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            // Populate RewardSession object here
	        	String id = resultSet.getString(1);
	            String firstname = resultSet.getString(2);
	            String secondname = resultSet.getString(3);
	            String feedbackformId = resultSet.getString(4);
	            String feedbackresponseId = resultSet.getString(5);
	            int rewardPoint=resultSet.getInt(6);
	            String rewardtype = resultSet.getString(7);
	            
	            Employee employee1=new Employee(null,null,null,987876876,null);
	            Employee employee2=new Employee(id,firstname,secondname,987876876,null);
	            FeedbackForm feedbackForm=new FeedbackForm(feedbackformId,null,null,null,null,null);
	            FeedbackResponse feedbackResponse=new FeedbackResponse(feedbackresponseId,feedbackForm,employee2,0,0,0,0,0); 
	            Performance performance =new Performance(null,employee1,employee2,"2024-05-01",rewardPoint,feedbackForm,feedbackResponse);
	            RewardSession rewardSession=new RewardSession(0,performance,employee2,rewardtype,feedbackForm,feedbackResponse);	            
	            bestPerformers.add(rewardSession);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return bestPerformers;
	}

	public static ArrayList<RewardSession> getEmployeesWithRewards(Connection connection,int choice) {
	    ArrayList<RewardSession> employeesWithRewards = new ArrayList<>();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        String query = "SELECT distinct e.id,e.firstname,e.secondname,rs.feedbackform_id,rs.feedbackresponse_id,p.rewardpoints,rs.rewardtype FROM employee e INNER JOIN rewardsession rs ON e.id = rs.assignedto inner join performance p on p.pointassignedto=rs.assignedto;";
	        		
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
	            String rewardtype = resultSet.getString(7);
	            
	            Employee employee1=new Employee(null,null,null,987876876,null);
	            Employee employee2=new Employee(id,firstname,secondname,987876876,null);
	            FeedbackForm feedbackForm=new FeedbackForm(feedbackformId,null,null,null,null,null);
	            FeedbackResponse feedbackResponse=new FeedbackResponse(feedbackresponseId,feedbackForm,employee2,0,0,0,0,0); 
	            Performance performance =new Performance(null,employee1,employee2,"2024-05-01",rewardPoint,feedbackForm,feedbackResponse);
	            RewardSession rewardSession=new RewardSession(0,performance,employee2,rewardtype,feedbackForm,feedbackResponse);	            
	            employeesWithRewards.add(rewardSession);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    
	    return employeesWithRewards;
	}
    
}