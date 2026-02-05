package kr.spartaclub.plan.service;


import kr.spartaclub.plan.dto.*;
import kr.spartaclub.plan.entity.Comment;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.CommentRepository;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final CommentRepository commentRepository;

    @Transactional //일정 생성
    public CreatePlanResponseDto save(CreatePlanRequestDto request) {
        Plan plan = new Plan(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        Plan savedPlan = planRepository.save(plan);
        return new CreatePlanResponseDto(
                savedPlan.getPlanId(),
                savedPlan.getTitle(),
                savedPlan.getContent(),
                savedPlan.getAuthor(),
                savedPlan.getCreatedAt(),
                savedPlan.getModifiedAt()
        );
    }

    @Transactional(readOnly = true) //일정 단건 조회
    public GetCommentPlanResponse findOne(Long planId){
        Plan plan = planRepository.findById(planId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        List<Comment> comments = commentRepository.findByPlanPlanId(planId);
        return new GetCommentPlanResponse(plan, comments);
    }

    @Transactional(readOnly = true) //일정 조회
    public List<GetPlanResponseDto> findAll(String author) {
        List<Plan> plans = planRepository.findAll();
        List<GetPlanResponseDto> dtos = new ArrayList<>();

        if(author == null || author.isBlank()) {
            for (Plan plan : plans) {
                GetPlanResponseDto dto = new GetPlanResponseDto(plan);
                dtos.add(dto);
            }
        }else{
            for (Plan plan : plans) {
                if (plan.getAuthor().equals(author)) {
                    GetPlanResponseDto dto = new GetPlanResponseDto(plan);
                    dtos.add(dto);
                }
            }
        }
        dtos.sort(Comparator.comparing(GetPlanResponseDto::getAuthor));
        return dtos;
    }

    @Transactional //일정 단건 수정
    public UpdatePlanResponseDto updatePlan(Long planId, UpdatePlanRequestDto requestDto) {
        Plan plan = planRepository.findById(planId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(!plan.getPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        plan.updatePlan(requestDto.getTitle(), requestDto.getAuthor());
        return new UpdatePlanResponseDto(plan.getPlanId());
    }

    @Transactional //일정 단건 삭제
    public void delete(Long planId, String password) {
        Plan plan = planRepository.findById(planId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(!plan.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        planRepository.deleteById(planId);
    }
}
