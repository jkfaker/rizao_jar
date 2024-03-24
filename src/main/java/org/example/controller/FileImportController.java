package org.example.controller;


import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.service.FileImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/manage/file")
public class FileImportController {

    @Autowired
    FileImportService fileImportService;

    @PostMapping
    public Result importGoodsFile(MultipartFile file) throws IOException, CsvException {
        log.info("文件批量导入商品信息");
        fileImportService.uploadFile(file);
        return Result.success();
    }
}
