package kr.spartaclub.plan.dto;

import lombok.Getter;

@Getter
public class GetCommentRequest {
    private String commentContent;
    private String commentAuthor;
    private Long planId;
}
