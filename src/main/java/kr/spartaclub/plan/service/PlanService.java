package kr.spartaclub.plan.service;

import jakarta.transaction.Transactional;
import kr.spartaclub.plan.dto.CreatePlanRequestDto;
import kr.spartaclub.plan.dto.CreatePlanResponseDto;
import kr.spartaclub.plan.dto.PlanResponseDto;
import kr.spartaclub.plan.dto.UpdatePlanRequestDto;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;


    @Transactional
    public CreatePlanResponseDto save(CreatePlanRequestDto dto) {
        Plan plan = new Plan(request.getTitle());
        Plan savedPlan = PlanRepository.save(plan);
        return new CreatePlanResponseDto(
                savedPlan.getId(),
                savedPlan.getTitle(),
                savedPlan.getContent(),
                savedPlan.getAuthor(),
                savedPlan.getCreatedAt(),
                savedPlan.getModifiedAt()
        );
    }

    public PlanResponseDto searchAllPlan(PlanResponseDto dto){

    }

    public PlanResponseDto searchEachPlan(PlanResponseDto dto){

    }

    public PlanResponseDto updatePlan(UpdatePlanRequestDto dto){

    }

//    public PlanResponseDto deletePlan()
}
