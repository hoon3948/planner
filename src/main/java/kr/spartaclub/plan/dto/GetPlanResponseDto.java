package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPlanResponseDto {
    private final Long planId;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetPlanResponseDto(Long planId, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.planId = planId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
