package com.nauka;

import com.nauka.db.entity.Department;
import com.nauka.db.entity.Employee;
import com.nauka.db.service.DepartmentService;
import com.nauka.db.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertDataTest {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @Test
    public void checkDB() {
        Employee employee1 = new Employee(
                "Ivanov","Ivan","Ivanovich","Director",12345
        );
        Employee employee2 = new Employee(
                "Andreev","Andrey","Andreevich","president",54321
        );

        Employee employee3 = new Employee(
                "Test","Test","Test","test",1
        );


        Department department1 = new Department("IT");
        Department department2 = new Department("Marketing");

        employee1.setDepartment(department1);
        employee2.setDepartment(department1);
        employee3.setDepartment(department2);

        departmentService.createDepartment(department1);
        departmentService.createDepartment(department2);

        employeeService.createEmployee(employee1);
        employeeService.createEmployee(employee2);
        employeeService.createEmployee(employee3);

        Assert.assertTrue(departmentService.findAllDepartments().size() >=2);
        Assert.assertTrue(employeeService.findAllEmployees().size() >=3);
    }
}