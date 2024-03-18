package org.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private Integer salesVolume;
    private String price;
    private String detail;
    private String producer;
    private String classification;
}
