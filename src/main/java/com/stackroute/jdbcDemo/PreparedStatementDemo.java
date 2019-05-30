package com.stackroute.jdbcDemo;

import java.sql.*;

public class PreparedStatementDemo {

    public void getCourseByName(String name){

        //Connection connection=null;
        //PreparedStatement preparedStatement=null;
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
        PreparedStatement preparedStatement=connection.prepareStatement("select * from course where name=?")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            //preparedStatement=connection.prepareStatement("select * from course where name=?");
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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
             PreparedStatement preparedStatement=connection.prepareStatement("select * from course where name=? and duration=?");
             ResultSet resultSet=preparedStatement.executeQuery()
        ){
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,duration);

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
