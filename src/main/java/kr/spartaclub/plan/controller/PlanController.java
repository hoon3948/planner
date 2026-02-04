package kr.spartaclub.plan.controller;

import kr.spartaclub.plan.dto.CreatePlanRequestDto;
import kr.spartaclub.plan.dto.CreatePlanResponseDto;
import kr.spartaclub.plan.dto.PlanResponseDto;
import kr.spartaclub.plan.dto.UpdatePlanRequestDto;
import kr.spartaclub.plan.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanController {
    private final PlanService planService;


    @PostMapping("/plans") //일정 생성
    public ResponseEntity<CreatePlanResponseDto> createPlan(@RequestBody CreatePlanRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.wait(request));
    }

    @GetMapping("/plans/") // 일정 조회
    public PlanResponseDto searchAllPlan(@RequestBody PlanResponseDto dto)

    @GetMapping("/plans/{id}") // 일정 단건 조회
    public PlanResponseDto searchEachPlan(@RequestBody PlanResponseDto dto)

    @PutMapping("/plans/{id}")// 일정 수정
    public PlanResponseDto updatePlan(@RequestBody UpdatePlanRequestDto dto)

    @DeleteMapping("/plans/{id}")//일정 삭제


}
