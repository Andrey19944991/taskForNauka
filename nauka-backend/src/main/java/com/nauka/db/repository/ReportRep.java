package com.nauka.db.repository;

import com.nauka.db.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRep extends JpaRepository<Report, Integer> {
}
