package kr.spartaclub.plan.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(length = 200, nullable = false)
    private String commentContent;
    @Column(nullable = false)
    private String commentAuthor;
    @Column(nullable = false)
    private String commentPassword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    public Comment(String commentContent,String commentAuthor, String commentPassword, Plan plan){
        this.commentContent = commentContent;
        this.commentAuthor = commentAuthor;
        this.commentPassword = commentPassword;
        this.plan = plan;
    }

    private void updateComment(String commentContent, String commentAuthor){
        this.commentContent = commentContent;
        this.commentAuthor = commentAuthor;
    }
}
