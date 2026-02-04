package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePlanResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifidAt;

    public CreatePlanResponseDto(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifidAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifidAt = modifidAt;
    }
}
