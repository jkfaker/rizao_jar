package org.example.service;

import javax.servlet.http.HttpSession;

public interface SmsService {
    void aliyunSmsService(String phone, HttpSession session) throws Exception;

    Integer codeVerify(String phone, String code, HttpSession session);
}
