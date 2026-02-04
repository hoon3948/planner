package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePlanResponseDto {

    private final Long planId;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreatePlanResponseDto(Long planId, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifidAt){
        this.planId = planId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifidAt;
    }
}
