package ru.fds.tavrzcms_export.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.fds.tavrzcms_export.domain.Report;

public interface ReportRepository extends MongoRepository<Report, String> {
}
