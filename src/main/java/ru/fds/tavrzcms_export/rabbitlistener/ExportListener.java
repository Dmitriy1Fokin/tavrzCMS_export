package ru.fds.tavrzcms_export.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.fds.tavrzcms_export.domain.ReportTask;
import ru.fds.tavrzcms_export.service.ReportService;

@EnableRabbit
@Component
public class ExportListener {

    private final ReportService reportService;

    public ExportListener(ReportService reportService) {
        this.reportService = reportService;
    }

    @RabbitListener(queues = "${queue_name}")
    public void addReportTask(ReportTask reportTask){
        reportService.addReport(reportTask.getTypeOfReport(),
                reportTask.getUsername(),
                reportTask.getTargetObjectId(),
                reportTask.getSourceObjectId());
    }
}
