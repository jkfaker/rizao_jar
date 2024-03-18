package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.GoodsImg;

import java.util.List;

@Mapper
public interface ImgMapper {

    @Insert("insert into rizao.goods_images(img_id, goods_id, image_name) VALUES (#{imgId}, #{goodsId}, #{imageName})")
    public void insert(GoodsImg goodsImg);


    List<GoodsImg> selectByGoodsId(Integer goodsId);

    @Delete("delete from rizao.goods_images where goods_id = #{id}")
    void deleteByGoodsId(Integer id);
}
