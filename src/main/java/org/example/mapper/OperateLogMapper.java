package org.example.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.AdminOperationLog;

@Mapper
public interface OperateLogMapper {
    //插入日志数据
    @Insert("insert into rizao.admin_operation_log (operation_user_id, operation_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operationUserId}, #{operationTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(AdminOperationLog log);
}