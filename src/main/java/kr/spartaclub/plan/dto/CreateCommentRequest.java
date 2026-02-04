package kr.spartaclub.plan.dto;

import jakarta.persistence.Column;
import kr.spartaclub.plan.entity.BaseEntity;
import lombok.Getter;

@Getter
public class CreateCommentRequest extends BaseEntity {
    private String commentContent;
    private String commentAuthor;
    private String commentPassword;
}
