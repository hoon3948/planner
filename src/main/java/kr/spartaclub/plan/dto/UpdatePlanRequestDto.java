package kr.spartaclub.plan.dto;

import lombok.Getter;

@Getter
public class UpdatePlanRequestDto {
    private Long planId;
    private String title;
    private String author;
    private String password;
}
