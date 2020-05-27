package com.nauka.db.service;

import com.nauka.db.entity.Employee;
import com.nauka.db.repository.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRep employeeRep;

    public Employee createEmployee(Employee employee) {
        return employeeRep.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRep.findAll();
    }
}
