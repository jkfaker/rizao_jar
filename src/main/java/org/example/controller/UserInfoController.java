package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.pojo.UserInfo;
import org.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加商品的非图片信息，添加图片信息另外写一个方法
     * @param userInfo
     * @return
     */
    @Log
    @PostMapping("/manage/userInfo")
    public Result add(@RequestBody UserInfo userInfo){
        log.info("添加的用户详细信息：{}", userInfo);
        userInfoService.add(userInfo);
        log.info("已添加！！！！");
        return Result.success();
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     **/

    @RequestMapping( value = {"/manage/userInfo","/user/userInfo"})
    public Result find(@RequestParam("id") Integer id)
    {
        log.info("查询的用户信息为{}",id);
        List<UserInfo> userInfoList = userInfoService.find(id);
        log.info("查询到的用户详细信息：{}", userInfoList);
        return Result.success(userInfoList);
    }


    /**
     *更新用户信息
     **/
    @Log
    @PutMapping(value = {"/manage/userInfo","/user/userInfo"})
    public Result update(@PathVariable("id") Integer id, @RequestBody UserInfo userInfo) {
        userInfoService.update(userInfo);
        return Result.success();
    }
}

