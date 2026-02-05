package kr.spartaclub.plan.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kr.spartaclub.plan.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "planId",
        "commentId",
        "commentContent",
        "commentAuthor",
        "createdAt",
        "modifiedAt"
})
@Getter
public class CreateCommentResponse {
    private final Long commentId;
    private final String commentContent;
    private final String commentAuthor;
    private final Long planId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateCommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.planId = comment.getPlan().getPlanId();
        this.commentContent = comment.getCommentContent();
        this.commentAuthor = comment.getCommentAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
