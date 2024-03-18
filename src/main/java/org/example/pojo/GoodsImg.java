package org.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *  imgId为商品图片先后序号（1 ~ 6）
 *  goodsId为商品外键
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsImg {
    private Integer imgId;
    private Integer goodsId;
    private String imageName;
}
