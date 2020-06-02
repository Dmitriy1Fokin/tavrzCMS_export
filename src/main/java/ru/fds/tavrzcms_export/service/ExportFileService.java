package ru.fds.tavrzcms_export.service;

import org.springframework.web.multipart.MultipartFile;
import ru.fds.tavrzcms_export.domain.ExportFile;

import java.io.IOException;
import java.util.Optional;

public interface ExportFileService {
    String addFile(String title, MultipartFile file) throws IOException;
    Optional<ExportFile>getFile(String id) throws IOException;
}
