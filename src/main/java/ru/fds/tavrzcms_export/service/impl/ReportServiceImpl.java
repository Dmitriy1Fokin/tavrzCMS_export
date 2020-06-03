package ru.fds.tavrzcms_export.service.impl;

import org.springframework.stereotype.Service;
import ru.fds.tavrzcms_export.dictionary.TypeOfReport;
import ru.fds.tavrzcms_export.domain.Report;
import ru.fds.tavrzcms_export.repository.ReportRepository;
import ru.fds.tavrzcms_export.service.ReportService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void addReport(TypeOfReport typeOfReport, String username, String targetObjectId, String sourceObjectId) {
        Report report = Report.builder()
                .typeOfReport(typeOfReport)
                .timeStart(LocalDateTime.now())
                .username(username)
                .targetObjectId(targetObjectId)
                .sourceObjectId(sourceObjectId)
                .build();

        reportRepository.save(report);
    }

    @Override
    public Collection<Report> getReports() {
        return null;
    }

    @Override
    public Optional<Report> getReport(String id) {
        return Optional.empty();
    }

    @Override
    public Report editReport(Report report) {
        return null;
    }
}
