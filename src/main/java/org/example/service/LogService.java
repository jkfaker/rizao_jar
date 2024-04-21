package org.example.service;

import org.example.pojo.AdminOperationLog;

import java.util.List;

public interface LogService {
     List<AdminOperationLog> findAllLogs();
}
