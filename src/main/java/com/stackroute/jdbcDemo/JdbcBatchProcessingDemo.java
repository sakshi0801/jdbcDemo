package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcBatchProcessingDemo {

    public void performMultipleInsertion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            Statement statement=connection.createStatement();

            String query1="insert into course values(6,'j2ee',6)";
            String query2="insert into course values(7,'hibernate',3)";

            statement.addBatch(query1);
            statement.addBatch(query2);

            int[] count=statement.executeBatch();
        }
        catch (ClassNotFoundException cnfException){
            System.out.println("Exception thrown "+cnfException.getStackTrace());
        }
        catch (SQLException sqlException){
            System.out.println("Exception thrown "+sqlException.getStackTrace());
        }
    }
}
