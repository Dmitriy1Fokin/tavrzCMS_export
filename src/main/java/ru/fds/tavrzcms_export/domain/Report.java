package ru.fds.tavrzcms_export.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.fds.tavrzcms_export.dictionary.TypeOfReport;

import java.time.LocalDateTime;

@Builder
@Document(collection = "reportDb")
public class Report {
    @Id
    String id;
    LocalDateTime timeStart;
    LocalDateTime timeDone;
    String username;
    TypeOfReport typeOfReport;
    String targetObjectId;
    String sourceObjectId;
    String fileId;
}