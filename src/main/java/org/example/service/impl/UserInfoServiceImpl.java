package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.GoodsMapper;
import org.example.mapper.UserInfoMapper;
import org.example.pojo.Goods;
import org.example.pojo.UserInfo;
import org.example.service.ImgService;
import org.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfo userInfo){
        log.info("这是GoodsServiceImpl的add()：{}",userInfo);
        userInfoMapper.add(userInfo);
    }

    @Override
    public List<UserInfo> find(Integer id) {
        return userInfoMapper.selectByAny(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws Exception {
        userInfoMapper.deleteById(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }
}
