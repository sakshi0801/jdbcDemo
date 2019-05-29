package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {

    public void getDatabaseMetaData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            DatabaseMetaData metaData=connection.getMetaData();
            System.out.println("Driver name is "+metaData.getDriverName());
            System.out.println("Driver version is "+metaData.getDriverVersion());
            System.out.println("Username is"+metaData.getUserName());
            System.out.println("Database product name is "+metaData.getDatabaseProductName());
            System.out.println("Database product version is "+metaData.getDatabaseProductVersion());
            System.out.println("URL is "+metaData.getURL());
        }
        catch (ClassNotFoundException cnfException){
            System.out.println("Exception thrown "+cnfException.getStackTrace());
        }
        catch (SQLException sqlException){
            System.out.println("Exception thrown "+sqlException.getStackTrace());
        }
    }
}
