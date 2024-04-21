package org.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * 专门记录管理员日志的pojo
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminOperationLog {
    private Integer id; //ID
    private Integer operationUserId; //操作人ID
    private LocalDateTime operationTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
    private Long costTime; //操作耗时
}
