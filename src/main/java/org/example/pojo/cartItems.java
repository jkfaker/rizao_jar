package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class cartItems {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer quantity;
    private LocalDateTime addedTime;
}
