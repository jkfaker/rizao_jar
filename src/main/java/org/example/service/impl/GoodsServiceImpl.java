package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.mapper.GoodsMapper;
import org.example.mapper.ImgMapper;
import org.example.pojo.Goods;
import org.example.service.GoodsService;
import org.example.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ImgService imgService;

    @Override
    public void add(Goods goods){
        log.info("这是GoodsServiceImpl的add()：{}",goods);
        goodsMapper.add(goods);
    }

    @Override
    public List<Goods> find(Goods goods) {
        return goodsMapper.selectByAny(goods);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws Exception {
        imgService.deleteByGoodsId(id);
        goodsMapper.deleteById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.update(goods);
    }
}
