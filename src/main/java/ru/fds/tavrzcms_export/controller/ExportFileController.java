package ru.fds.tavrzcms_export.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.fds.tavrzcms_export.service.ExportFileService;

import java.io.IOException;

@RestController
@RequestMapping("/export")
public class ExportFileController {
    private final ExportFileService exportFileService;

    public ExportFileController(ExportFileService exportFileService) {
        this.exportFileService = exportFileService;
    }

    @PostMapping("/add")
    public String addFile(@RequestParam("title") String title,
                          @RequestParam("file") MultipartFile file) throws IOException {

        return exportFileService.addFile(title, file);
    }
}
