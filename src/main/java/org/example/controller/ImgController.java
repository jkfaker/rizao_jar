package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.anno.Log;
import org.example.pojo.GoodsImg;
import org.example.pojo.Result;
import org.example.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Slf4j
@RestController
public class ImgController {

    @Autowired
    private ImgService imgService;

    /**
     * 该方法即用于根据id查找图片，也用于列举全部图片
     * @param goodsId
     * @return
     */
    @RequestMapping(value = {"/manage/img","/img"})
    public Result find(@RequestParam(value = "id",required = false) Integer goodsId)
    {
        log.info("查询id为 {} 的商品图片", goodsId);
        List<GoodsImg> imgList = imgService.find(goodsId);
        return Result.success(imgList);
    }

    /**
     * 添加一组商品图片
     * @param imgId
     * @param goodsId
     * @param img
     * @return
     * @throws IOException
     */
    @Log
    @PostMapping("/manage/img")
    public Result add(Integer imgId, Integer goodsId, MultipartFile img) throws IOException {
        imgService.add(imgId, goodsId, img);
        return Result.success();
    }
}
