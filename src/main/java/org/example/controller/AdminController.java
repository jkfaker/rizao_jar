package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Admin;
import org.example.pojo.Result;
import org.example.service.AdminService;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/manage")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result checkLogin(@RequestBody Admin admin) {

        log.info("后台登录： {}", admin);
        Admin adm = adminService.checkLogin(admin);
        if (adm != null){
            // 返回JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", adm.getId());
            claims.put("username", adm.getUsername());
            claims.put("phone", adm.getPhone());

            String jwt = JwtUtils.generateJwt(claims);
            log.info(jwt);
            return Result.success(jwt);
        }
        // 登录失败，返回错误信息
        return Result.error("用户名或者密码错误！");
    }

    /**
     * 查询所有管理员id + 电话
     **/
    @RequestMapping("/admin")
    public Result findAllAdmin() {
        List<Admin> adminList = adminService.selectAllAdmin();
        return Result.success(adminList);
    }


}
