package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.LogMapper;
import org.example.pojo.AdminOperationLog;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public List<AdminOperationLog> findAllLogs() {
        return logMapper.findAllLogs();
    }
}
