package com.news.springboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NewsDto {
    private Integer id;
    private String title;
    private String text;
    private Date date;
    private Integer categoryId;
}
