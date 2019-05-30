package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcTransactionDemo {

    public void insertUsingTransaction(){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            Statement stmt = connection.createStatement();
            ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection.setAutoCommit(false);
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
