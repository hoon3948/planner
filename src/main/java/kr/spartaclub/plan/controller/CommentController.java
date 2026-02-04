package kr.spartaclub.plan.controller;

import kr.spartaclub.plan.dto.CreateCommentRequest;
import kr.spartaclub.plan.dto.CreateCommentResponse;
import kr.spartaclub.plan.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plans")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{planId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable Long planId,
            @RequestBody CreateCommentRequest requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(planId, requestDto));
    }
}