package kr.spartaclub.plan.dto;

import kr.spartaclub.plan.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {

    private final Long planId;
    private final String commentContent;
    private final String commentAuthor;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;



    public GetCommentResponse(Comment comment) {
        this.planId = comment.getPlan().getPlanId();
        this.commentContent = comment.getCommentContent();
        this.commentAuthor = comment.getCommentAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
