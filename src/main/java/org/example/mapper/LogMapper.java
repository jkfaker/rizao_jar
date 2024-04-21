package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.AdminOperationLog;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select("SELECT * FROM rizao.admin_operation_log ORDER BY operation_time DESC")
    List<AdminOperationLog> findAllLogs();
}
