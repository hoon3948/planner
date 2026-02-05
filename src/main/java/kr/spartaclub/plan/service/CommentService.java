package kr.spartaclub.plan.service;


import kr.spartaclub.plan.dto.CreateCommentRequest;
import kr.spartaclub.plan.dto.CreateCommentResponse;
import kr.spartaclub.plan.dto.GetCommentResponse;
import kr.spartaclub.plan.entity.Comment;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.CommentRepository;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PlanRepository planRepository;

    @Transactional //댓글 생성
    public CreateCommentResponse save(Long planId, CreateCommentRequest requestDto) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

        if (plan.getComments().size() >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지만 가능합니다.");
        }
        Comment comment = new Comment(
                requestDto.getCommentContent(),
                requestDto.getCommentAuthor(),
                requestDto.getCommentPassword(),
                plan
        );
        Comment savedComment = commentRepository.save(comment);
        return new CreateCommentResponse(savedComment);
    }

//    @Transactional(readOnly = true) //댓글 조회
//    public List<GetCommentResponse> findAll(Long planId) {
//        List<Comment> comments = commentRepository.findAll();
//        List<GetCommentResponse> dtos = new ArrayList<>();
//
//
//        for (Comment comment : comments) {
//            if (Objects.equals(comment.getPlan().getPlanId(), planId)) {
//                GetCommentResponse dto = new GetCommentResponse(comment);
//                dtos.add(dto);
//            }
//        }
//        return dtos;
//    }
}
