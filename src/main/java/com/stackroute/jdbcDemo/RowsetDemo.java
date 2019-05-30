package com.stackroute.jdbcDemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowsetDemo {
    public void getAllStudents() {

        //implement using rowset
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshi", "root", "Root@123");
            JdbcRowSet rowSet= RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/sakshi");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from course");
            rowSet.execute();
            rowSet.moveToCurrentRow();
            while (rowSet.previous()) {
                System.out.println("id=" + rowSet.getInt(1));
                System.out.println("name=" + rowSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        catch (ClassNotFoundException cnfException){
            cnfException.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
    public void getCourseByName(String name){

    }

    public void getCourseByNameAndDuration(String name,int duration){

    }
}
