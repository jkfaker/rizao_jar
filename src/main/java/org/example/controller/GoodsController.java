package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Goods;
import org.example.pojo.Result;
import org.example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Slf4j
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加商品的非图片信息，添加图片信息另外写一个方法
     * @param goods
     * @return
     */
    @PostMapping("/manage/goods")
    public Result add(@RequestBody Goods goods){
        log.info("添加的商品信息：{}", goods);
        goodsService.add(goods);
        log.info("已添加！！！！");
        return Result.success();
    }

    /**
     *  goods中的
     *  id,producer,classification支持精确查询，
     *  name，detail支持模糊查询
     * @param goods
     * @return
     */
    @RequestMapping( value = {"/manage/goods","/goods"})
    public Result find(@ModelAttribute Goods goods)
    {

        log.info("{}",goods);
        List<Goods> goodsList = goodsService.find(goods);
        log.info("查询到的商品信息：{}", goodsList);
        return Result.success(goodsList);
    }

    /**
     * 删除操作要先删除图片再删除信息
     * 并使用 @Transactional
     * @param id
     * @return
     */
    @DeleteMapping("manage/goods/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        goodsService.delete(id);
        log.info("删除的商品id：{}",id);
        return Result.success();
    }
}
