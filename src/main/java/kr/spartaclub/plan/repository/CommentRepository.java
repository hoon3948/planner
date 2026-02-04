package kr.spartaclub.plan.repository;


import kr.spartaclub.plan.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
