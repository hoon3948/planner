package kr.spartaclub.plan.service;


import kr.spartaclub.plan.dto.*;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<GetPlanResponseDto> findAll(String author) {
        List<Plan> plans = planRepository.findAll();
        List<GetPlanResponseDto> dtos = new ArrayList<>();

        if(author == null || author.isBlank()) {
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
        }else{
            for (Plan plan : plans) {
                if (plan.getAuthor().equals(author)) {
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
            }
        }
        dtos.sort(Comparator.comparing(GetPlanResponseDto::getAuthor));
        return dtos;
    }

    @Transactional
    public UpdatePlanResponseDto updatePlan(Long id, String password, UpdatePlanRequestDto requestDto) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(!plan.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        plan.updatePlan(requestDto.getTitle());
        return new UpdatePlanResponseDto(plan.getId());
    }

    @Transactional
    public void delete(Long id, String password) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(!plan.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        planRepository.deleteById(id);
    }
}
