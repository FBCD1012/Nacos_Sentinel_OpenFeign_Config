package com.example.entity;


import lombok.Data;


//构建借阅关系实体类
@Data
public class BookRealation {
    Integer id;
    Integer bid;
    Integer rid;
}
