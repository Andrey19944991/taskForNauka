package com.nauka.db.repository;

import com.nauka.db.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee, Integer> {
}
