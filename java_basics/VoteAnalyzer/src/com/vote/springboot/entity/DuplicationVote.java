package com.vote.springboot.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuplicationVote {
    private String station;
    private String name;
    private Integer count;
}