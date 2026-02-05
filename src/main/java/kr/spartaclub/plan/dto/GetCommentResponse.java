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
public class GetCommentResponse {

    private final Long planId;
    private final Long commentId;
    private final String commentContent;
    private final String commentAuthor;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;



    public GetCommentResponse(Comment comment, Long commentId) {
        this.planId = comment.getPlan().getPlanId();
        this.commentContent = comment.getCommentContent();
        this.commentAuthor = comment.getCommentAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.commentId = comment.getCommentId();
    }
}
