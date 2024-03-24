package org.example.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.mapper.ImgMapper;
import org.example.pojo.GoodsImg;
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
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    // 图片存放路径
    private static final String PATH = "/root/uploads/img/";
//    private static final String PATH = "C:\\Users\\29443\\Desktop\\uploads\\img\\";
    /**
     * 需要@Transactional
     * 先操作数据库，再上传文件，以便回溯
     * @param imgId
     * @param goodsId
     * @param img
     * @throws IOException
     */
    @Override
    @Transactional
    public void add(Integer imgId, Integer goodsId, MultipartFile img) throws IOException {
        //获取原始文件名
        String originalFilename;
        originalFilename = img.getOriginalFilename();
        // 构建新的文件名
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));// 获取文件扩展名
        String newFileName = UUID.randomUUID().toString()+extname;//
        // 随机名+文件扩展名
        // 返回文件名便于数据库储存,
        imgMapper.insert(new GoodsImg(imgId, goodsId, newFileName));
        // 将文件存储在服务器的磁盘目录
        img.transferTo(new File(PATH + newFileName));
        log.info("文件上传：{}",newFileName);
    }

    @Override
    public List<GoodsImg> find(Integer goodsId){
        return imgMapper.selectByGoodsId(goodsId);
    }

    /**
     * 1，查询需要删除的数据的文件名
     * 2，删除数据库中的数据
     * 3，删除本地文件
     * 需要用到事务
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByGoodsId(Integer id) throws Exception {
        // 1
        List<GoodsImg> imgList = find(id);
        // 2
        imgMapper.deleteByGoodsId(id);
        // 3
        for (GoodsImg img:imgList) {
            File file = new File(PATH + img.getImageName());
            boolean deleted = file.delete();
            if (deleted) log.info("文件删除成功：imageName：{}，goodsId：{}，imgId：{}", img.getImageName(),img.getGoodsId(),img.getImgId());
            else throw new Exception("文件删除失败！！！预期事务将RollBack");
        }
    }

}
