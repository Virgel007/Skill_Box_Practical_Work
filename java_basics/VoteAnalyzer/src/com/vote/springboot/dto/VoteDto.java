package com.vote.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteDto {
    private Integer id;
    private String name;
    private Date birthDay;
    private String station;
    private Date time;
}
