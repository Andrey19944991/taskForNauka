package com.nauka.db.repository;

import com.nauka.db.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRep extends JpaRepository<Department, Integer> {
}
