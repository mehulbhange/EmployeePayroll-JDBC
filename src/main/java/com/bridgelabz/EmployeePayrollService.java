package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Enumeration;

public class EmployeePayrollService {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String user = "root";
        String password = "root";
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        }catch (ClassNotFoundException ex){
            System.out.println(ex);
        }
        listDrivers();

        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("Connected...");
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
    private static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driver = (Driver) driverList.nextElement();
            System.out.println(" "+ driver.getClass().getName());
        }
    }

}
