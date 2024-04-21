package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.AdminOperationLog;
import org.example.pojo.Result;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/manage/logs")
public class LogController {

    @Autowired
    private LogService logService;
    @GetMapping
    public Result getAllLogs() {
        List<AdminOperationLog> logs = logService.findAllLogs();
        log.info("查询到的日志信息：{}", logs);
        return Result.success(logs);
    }
}
