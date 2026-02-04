package kr.spartaclub.plan.service;


import kr.spartaclub.plan.dto.CreateCommentRequest;
import kr.spartaclub.plan.dto.CreateCommentResponse;
import kr.spartaclub.plan.entity.Comment;
import kr.spartaclub.plan.entity.Plan;
import kr.spartaclub.plan.repository.CommentRepository;
import kr.spartaclub.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PlanRepository planRepository;

    @Transactional
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
}
