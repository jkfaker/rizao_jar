package org.example.service;

import com.opencsv.exceptions.CsvException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileImportService {
    void addByFiles(String csvFilePath) throws IOException, CsvException;

    void uploadFile(MultipartFile file) throws IOException, CsvException;
}
