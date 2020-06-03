package ru.fds.tavrzcms_export.domain;

import lombok.Getter;
import ru.fds.tavrzcms_export.dictionary.TypeOfReport;

@Getter
public class ReportTask {
    TypeOfReport typeOfReport;
    String targetObjectId;
    String sourceObjectId;
    String username;
}
