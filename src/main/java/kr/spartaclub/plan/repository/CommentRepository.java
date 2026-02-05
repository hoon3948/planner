package kr.spartaclub.plan.repository;


import kr.spartaclub.plan.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPlanPlanId(Long planId);
}
