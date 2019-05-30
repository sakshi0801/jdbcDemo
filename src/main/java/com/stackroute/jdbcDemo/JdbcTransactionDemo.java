package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcTransactionDemo {

    public void insertUsingTransaction(){
        Connection connection=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            Savepoint savepoint=connection.setSavepoint("Savepoint");
            String query="Insert into course values(9,'SAP',3)";
            stmt.executeUpdate(query);

            Savepoint savepoint1=connection.setSavepoint("Savepoint1");
            String query2="Insert into course values(10,'Oracle',5)";
            stmt.executeUpdate(query2);
            connection.rollback(savepoint1);
            connection.commit();
        }
        catch (ClassNotFoundException cnfException){
            System.out.println(cnfException.getStackTrace());
        }

        catch (SQLException sqlException){
            System.out.println(sqlException.getStackTrace());
        }
    }
}
