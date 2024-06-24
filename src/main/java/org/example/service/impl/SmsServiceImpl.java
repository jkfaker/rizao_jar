package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.service.SmsService;
import org.example.utils.SmsUtils;
import org.example.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    private final Integer codeLength = 6;

    @Autowired
    private SmsUtils smsUtils;

    @Override
    public void aliyunSmsService(String phone, HttpSession session) throws Exception {
        session.setAttribute("phone", phone);
        String code = ValidateCodeUtils.generateValidateCode(codeLength);
        session.setAttribute("code", code);
        log.info("HttpSession: {}",session.hashCode());
        smsUtils.sendMessage(phone, code);
        return ;
    }

    @Override
    public Integer codeVerify(String phone, String code, HttpSession session) {
        log.info("HttpSession: {}", session.hashCode());
        log.info("用户发送的验证码为：{},手机号码为： {}", code, phone);
        String sessionPhone = (String) session.getAttribute("phone");

        String sessionCode = (String) session.getAttribute("code");
        log.info("session中的验证码为：{}, 手机号码为： {}", sessionCode, sessionPhone);
        if (phone.equals(sessionPhone) && (code.equals(sessionCode))) {
            log.info("验证成功");
            return 1;
        }
        log.info("验证失败");
        return 0;
    }
}
