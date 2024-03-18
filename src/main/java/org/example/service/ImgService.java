package org.example.service;


import org.example.pojo.GoodsImg;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImgService {
    void add(Integer imgId, Integer goodsId, MultipartFile img) throws IOException;

    List<GoodsImg> find(Integer goodsId);

    void deleteByGoodsId(Integer id) throws Exception;
}
