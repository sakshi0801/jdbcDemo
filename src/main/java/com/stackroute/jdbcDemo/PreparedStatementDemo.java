package com.stackroute.jdbcDemo;

import java.sql.*;

public class PreparedStatementDemo {

    public void getCourseByName(String name){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            PreparedStatement preparedStatement=connection.prepareStatement("select * from course where name=?");
            preparedStatement.setString(1,name);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
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

    public void getCourseByNameAndDuration(String name,int duration){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            PreparedStatement preparedStatement=connection.prepareStatement("select * from course where name=? and duration=?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,duration);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
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
