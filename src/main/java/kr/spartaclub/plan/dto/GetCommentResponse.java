package kr.spartaclub.plan.dto;

import kr.spartaclub.plan.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {

    private final String commentContent;
    private final String commentAuthor;
    private final Long planId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetCommentResponse(Comment comment) {
        this.commentContent = comment.getCommentContent();
        this.commentAuthor = comment.getCommentAuthor();
        this.planId = comment.getPlan().getPlanId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
