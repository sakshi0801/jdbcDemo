package com.stackroute.jdbcDemo;

import java.sql.*;

public class DataManager {

    public void getAllStudents() {
        //register driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from course");

            //to print in reverse order
            //resultSet.afterLast();
            //use resultSet.previous() in while loop
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name=resultSet.getString(2);
                int duration=resultSet.getInt(3);
                System.out.println(id+"\t"+name+"\t"+duration);
            }
        }
        catch (ClassNotFoundException cnfException){
            System.out.println("Exception thrown "+cnfException.getStackTrace());
        }
        catch (SQLException sqlException){
            System.out.println("Exception thrown "+sqlException.getStackTrace());
        }
    }
}