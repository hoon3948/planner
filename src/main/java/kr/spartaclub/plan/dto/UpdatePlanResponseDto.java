package kr.spartaclub.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdatePlanResponseDto {

    private final Long id;
    priv

    public UpdatePlanResponseDto(Long id){
        this.id = id;
    }
}
