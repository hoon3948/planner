package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePlanRequestDto {

    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;


}
