package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.service.SmsService;
import org.example.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信并记录到session中
     */
    @PostMapping("/Request")
    public Result identifyCode(@RequestParam("phoneNumber")String phoneNumber, HttpSession session) throws Exception {
        smsService.aliyunSmsService(phoneNumber, session);
        return Result.success();
    }
}
