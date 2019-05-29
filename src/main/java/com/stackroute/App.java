package com.stackroute;

import com.stackroute.jdbcDemo.DataManager;
import com.stackroute.jdbcDemo.JdbcBatchProcessingDemo;
import com.stackroute.jdbcDemo.PreparedStatementDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataManager dataManager=new DataManager();
        dataManager.getAllStudents();

        System.out.println("----Using prepared Statement----");
        PreparedStatementDemo preparedStatementDemo=new PreparedStatementDemo();
        System.out.println("Get Course By name");
        preparedStatementDemo.getCourseByName("spring");
        System.out.println("Get Course By name and duration");
        preparedStatementDemo.getCourseByNameAndDuration("angular",5);

        System.out.println("using batch processing");
        JdbcBatchProcessingDemo batchDemo=new JdbcBatchProcessingDemo();
        batchDemo.performMultipleInsertion();

        dataManager.getAllStudents();

    }
}
