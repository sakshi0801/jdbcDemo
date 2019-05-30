package com.stackroute;

import com.stackroute.jdbcDemo.*;

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

/*
        System.out.println("using batch processing");
        JdbcBatchProcessingDemo batchDemo=new JdbcBatchProcessingDemo();
        batchDemo.performMultipleInsertion();
        dataManager.getAllStudents();
*/

        System.out.println("Database Meta-data");
        DatabaseMetaDataDemo metaDataDemo=new DatabaseMetaDataDemo();
        metaDataDemo.getDatabaseMetaData();

        System.out.println("Result set Meta-data");
        ResultSetMetaDataDemo setMetaDataDemo=new ResultSetMetaDataDemo();
        setMetaDataDemo.getResultSetMetadata();

/*
        System.out.println("JDBC transaction using rollback");
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.insertUsingTransaction();
        dataManager.getAllStudents();
*/

/*
        System.out.println("Using rowset");
        RowsetDemo rowsetDemo=new RowsetDemo();
        rowsetDemo.getAllStudents();
*/

    }
}
