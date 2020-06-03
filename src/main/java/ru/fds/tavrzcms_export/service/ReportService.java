package ru.fds.tavrzcms_export.service;

import ru.fds.tavrzcms_export.dictionary.TypeOfReport;
import ru.fds.tavrzcms_export.domain.Report;

import java.util.Collection;
import java.util.Optional;


public interface ReportService {
    void addReport(TypeOfReport typeOfReport, String username, String targetObjectId, String sourceObjectId);
    Collection<Report> getReports();
    Optional<Report> getReport(String id);
    Report editReport(Report report);
}
