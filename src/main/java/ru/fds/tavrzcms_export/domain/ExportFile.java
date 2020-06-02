package ru.fds.tavrzcms_export.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

@Setter
@Getter
public class ExportFile {

    private String title;

    private InputStream file;
}
