package org.example.controller;

import jdk.jfr.Registered;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.SmsService;
import org.example.service.UserService;
import org.example.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/userLogin")
    public Result checkLogin(@RequestBody User user) {

        log.info("后台登录： {}", user);
        User usr = userService.checkLogin(user);
        if (usr != null){
            // 返回JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", usr.getUserId());
            claims.put("username", usr.getUsername());
            claims.put("phone", usr.getPhone());
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
    @RequestMapping("/user")
    public Result findAllAdmin() {
        List<User> userList = userService.selectAllUser();
        return Result.success(userList);
    }

    @PutMapping("/user/{id}")
    public Result delete(@PathVariable Integer id){
        userService.delete(id);
        return Result.success();
    }

    @PostMapping("/userRegister")
    public Result registerByUsername(@RequestBody User user, HttpServletRequest request) {
        userService.addUser(user);
        return Result.success();
    }
    @PostMapping("/userRegister1")
    public Result registerByPhone(@RequestBody User user, HttpServletRequest request) {
        Integer pass = userService.registerVerify(user, request);
        if (pass != 1)
            return Result.error("验证码错误！");
        userService.addUser(user);
        return Result.success();
    }
}
