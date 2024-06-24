package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer userId;
    private String avatar;
    private Short gender;
    private String username;
    private String job;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private String shoppingPreferences;
    private Short isActive;
}
