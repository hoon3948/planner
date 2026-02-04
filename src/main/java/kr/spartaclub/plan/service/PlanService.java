package kr.spartaclub.plan.service;


import kr.spartaclub.plan.dto.*;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;


    @Transactional
    public CreatePlanResponseDto save(CreatePlanRequestDto request) {
        Plan plan = new Plan(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        Plan savedPlan = planRepository.save(plan);
        return new CreatePlanResponseDto(
                savedPlan.getId(),
                savedPlan.getTitle(),
                savedPlan.getContent(),
                savedPlan.getAuthor(),
                savedPlan.getCreatedAt(),
                savedPlan.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetPlanResponseDto findOne(Long id){
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetPlanResponseDto(
                plan.getId(),
                plan.getTitle(),
                plan.getContent(),
                plan.getAuthor(),
                plan.getCreatedAt(),
                plan.getModifiedAt()
        );

    }

    @Transactional(readOnly = true)
    public List<GetPlanResponseDto> findAll() {
        List<Plan> plans = planRepository.findAll();

        List<GetPlanResponseDto> dtos = new ArrayList<>();
        for (Plan plan : plans) {
            GetPlanResponseDto dto = new GetPlanResponseDto(
              plan.getId(),
              plan.getTitle(),
              plan.getContent(),
              plan.getAuthor(),
              plan.getCreatedAt(),
              plan.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdatePlanResponseDto updatePlan(Long id, UpdatePlanRequestDto requestDto) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        plan.updatePlan(requestDto.getTitle());
        return new UpdatePlanResponseDto(plan.getId());
    }

    @Transactional
    public void delete(Long id) {
        boolean existence = planRepository.existsById(id);
        if(!existence){
            throw new IllegalStateException("없는 일정입니다.");
        }
        planRepository.deleteById(id);
    }
}
