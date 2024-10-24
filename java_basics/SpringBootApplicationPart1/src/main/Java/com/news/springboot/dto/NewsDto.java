package com.news.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class NewsDto {
    private long id;
    private String title;
    private String text;
    private Date date;
}
