package kr.spartaclub.plan.dto;

import lombok.Getter;

@Getter
public class PlanResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String date;
}
