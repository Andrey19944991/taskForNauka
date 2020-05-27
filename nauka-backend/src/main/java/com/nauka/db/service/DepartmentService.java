package com.nauka.db.service;

import com.nauka.db.entity.Department;
import com.nauka.db.repository.DepartmentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRep departmentRep;

    public Department createDepartment(Department department) {
        return departmentRep.save(department);
    }

    public List<Department> findAllDepartments() {
        return departmentRep.findAll();
    }
}
