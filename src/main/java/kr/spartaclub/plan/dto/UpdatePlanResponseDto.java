package kr.spartaclub.plan.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "planId",
        "title",
        "content",
        "author",
        "createdAt",
        "modifiedAt"
})
@Getter
public class UpdatePlanResponseDto {

    private final Long planId;

    public UpdatePlanResponseDto(Long planId){
        this.planId = planId;
    }
}
