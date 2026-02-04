package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdatePlanResponseDto {

    private final Long planId;

    public UpdatePlanResponseDto(Long planId){
        this.planId = planId;
    }
}
