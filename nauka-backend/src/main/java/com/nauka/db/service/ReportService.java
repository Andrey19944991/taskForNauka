package com.nauka.db.service;

import com.nauka.db.entity.Report;
import com.nauka.db.repository.ReportRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRep reportRep;

    public Report createReport(Report report) {
        return reportRep.save(report);
    }

    public List<Report> findAllReports() {
        return reportRep.findAll();
    }
}
