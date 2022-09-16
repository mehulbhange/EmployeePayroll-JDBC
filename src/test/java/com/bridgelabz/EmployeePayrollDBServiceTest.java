package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){

        EmployeePayrollDBService employeePayrollDBService = EmployeePayrollDBService.getInstance();
        List<EmployeePayroll> retrivedEmpList = employeePayrollDBService.readData();
        //System.out.println(retrivedEmpList);
        Assertions.assertEquals(3,retrivedEmpList.size());

    }

}
