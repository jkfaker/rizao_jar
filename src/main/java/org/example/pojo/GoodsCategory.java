package org.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 这个类是专门给商品进行分页查询用的
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCategory {
    private Integer id;
    private String name;
    private Integer salesVolume;
    private String price;
    private String detail;
    private String producer;
    private String classification;
    private Double priceMin;
    private Double priceMax;
    private Integer sort;  // 0为默认，1为name正序，2为name逆序，3为price正序，4为price逆序
    private Integer page;
    private Integer number;
}
