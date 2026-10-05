package com.web.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author Ari
 * Date 2026/1/21
 * Desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppBean {

    //CREATE TABLE `users_info` (
    //  `id` INT PRIMARY KEY AUTO_INCREMENT,
    //  `username` text COLLATE utf8mb4_unicode_ci,
    //  `gender` text COLLATE utf8mb4_unicode_ci,
    //  `age` text COLLATE utf8mb4_unicode_ci,
    //  `occupation` text COLLATE utf8mb4_unicode_ci,
    //  `zip_code` text COLLATE utf8mb4_unicode_ci
    //) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

    Integer id;
    String username;
    String gender;
    String age;
    String occupation;
    String zipCode;


}
