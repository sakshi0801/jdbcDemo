package com.stackroute.jdbcDemo;

import java.sql.*;

public class ResultSetMetaDataDemo {

    public void getResultSetMetadata(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from course");
            ResultSetMetaData setMetaData=resultSet.getMetaData();

            System.out.println("Table name is "+setMetaData.getTableName(1));
            System.out.println("number of columns :"+setMetaData.getColumnCount());
            System.out.println("Column 1 is "+setMetaData.getColumnName(1));
            System.out.println("Column type is "+setMetaData.getColumnTypeName(1));
            System.out.println("Column size is "+setMetaData.getColumnDisplaySize(1));
        }
        catch (ClassNotFoundException cnfException){
            System.out.println("Exception thrown "+cnfException.getStackTrace());
        }
        catch (SQLException sqlException){
            System.out.println("Exception thrown "+sqlException.getStackTrace());
        }
    }
}
