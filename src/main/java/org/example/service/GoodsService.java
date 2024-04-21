package org.example.service;

import org.example.pojo.Goods;
import org.example.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GoodsService {
    void add(Goods goods);

    List<Goods> find(Goods goods);

    void delete(Integer id) throws Exception;

    void updateGoods(Goods goods);
}
