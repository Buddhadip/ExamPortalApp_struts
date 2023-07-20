package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;



public class QuestionToExamDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;

    public QuestionToExamDAO() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/exam_master";
        this.jdbcUsername = "root";
        this.jdbcPassword = "root";
    }

    // Establishes a database connection
    protected void connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    // Closes the database connection
    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    
    // Method to insert a new QuestionToExam relationship into the "QuestionToExam" table
    public void insertQuesToExam(int qid, int eid) throws SQLException {
        
    	connect();
    	String sql = "INSERT INTO QuestionToExam (Qid, Eid) VALUES (?, ?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, qid);
            statement.setInt(2, eid);
            
            statement.executeUpdate();
            
            statement.close();
            disconnect();
    }
    
    // Method to retrieve all question IDs associated with a specific exam ID
    public List<Integer> retrieveQues(int eid) throws SQLException {
        
    	connect();
    	List<Integer> questionIds = new ArrayList<>();
        
        String sql = "SELECT Qid FROM QuestionToExam WHERE Eid = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql); 
            statement.setInt(1, eid);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int qid = resultSet.getInt("Qid");
                    questionIds.add(qid);
                }
            }
            
            statement.close();
            disconnect();
        
        return questionIds;
    }
    
}