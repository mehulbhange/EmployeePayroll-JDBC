package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBServiceTest {

    EmployeePayrollDBService employeePayrollDBService = EmployeePayrollDBService.getInstance();
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){

        List<EmployeePayroll> retrivedEmpList = employeePayrollDBService.readData();
        //System.out.println(retrivedEmpList);
        Assertions.assertEquals(3,retrivedEmpList.size());

    }

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() {

        employeePayrollDBService.updateEmployeeDataUsingStatement("Terissa",3000000.00);
        List<EmployeePayroll> retrivedEmpList = employeePayrollDBService.readData();
        double salary = 0;
        for (EmployeePayroll employee : retrivedEmpList){
            if (employee.getName().equals("Terissa")){
                salary = employee.getSalary();
                break;
            }
        }

        Assertions.assertEquals(3000000.00,salary);
    }

    @Test
    public void givenNewSalaryForEmployeeUsingPreparedStatement_WhenUpdated_ShouldSyncWithDB() {

        employeePayrollDBService.updateEmployeeDataUsingPreparedStatement("Terissa",3000000.00);
        List<EmployeePayroll> retrivedEmpList = employeePayrollDBService.readData();
        double salary = 0;
        for (EmployeePayroll employee : retrivedEmpList){
            if (employee.getName().equals("Terissa")){
                salary = employee.getSalary();
                break;
            }
        }

        Assertions.assertEquals(3000000.00,salary);
    }

}
