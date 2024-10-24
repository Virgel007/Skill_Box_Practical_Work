package com.news.springboot.dto;

import com.news.springboot.entity.News;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Integer id;
    private String title;
    private List<News> news;
}
