package kr.spartaclub.plan.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kr.spartaclub.plan.entity.Comment;
import kr.spartaclub.plan.entity.Plan;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonPropertyOrder({
        "planId",
        "title",
        "content",
        "author",
        "createdAt",
        "modifiedAt",
        "comments"
})
@Getter
public class GetCommentPlanResponse {

    private final Long planId;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    private final List<GetCommentResponse> comments;
    public GetCommentPlanResponse(Plan plan, List<Comment> comments){
        this.planId = plan.getPlanId();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.author = plan.getAuthor();
        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
        this.comments = comments.stream()
                .map(GetCommentResponse::new)
                .toList();
    }


}
