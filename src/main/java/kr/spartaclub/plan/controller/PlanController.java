package kr.spartaclub.plan.controller;

import kr.spartaclub.plan.dto.*;
import kr.spartaclub.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;


    @PostMapping("/plans") //일정 생성
    public ResponseEntity<CreatePlanResponseDto> createPlan(@RequestBody CreatePlanRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.save(requestDto));
    }

    @GetMapping("/plans/") // 일정 조회
    public ResponseEntity<List<GetPlanResponseDto>> getPlans(){
        return ResponseEntity.status(HttpStatus.OK).body(planService.findAll());
    }

    @GetMapping("/plans/{id}") // 일정 단건 조회
    public ResponseEntity<GetPlanResponseDto> getPlan(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(planService.findOne(id));
    }

    @PutMapping("/plans/{id}")// 일정 수정
    public ResponseEntity<UpdatePlanResponseDto> updatePlan(
            @PathVariable Long id,
            @RequestBody UpdatePlanRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(planService.updatePlan(id, requestDto));
    }

    @DeleteMapping("/plans/{id}")//일정 삭제
    public ResponseEntity<Void> deletePlan(@PathVariable Long id){
        planService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
