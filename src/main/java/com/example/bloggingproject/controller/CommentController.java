package com.example.bloggingproject.controller;

import com.example.bloggingproject.dto.request.CommentRequest;
import com.example.bloggingproject.filter.CommentFilter;
import com.example.bloggingproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping("list")
    public ResponseEntity<?> getCommentsList(CommentFilter filter){
        return ResponseEntity.ok(service.getCommentsList(filter));
    }

    @PostMapping("create")
    public ResponseEntity<?> createComment(@RequestBody CommentRequest request){
        return ResponseEntity.ok(service.createComment(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateComment(@RequestBody CommentRequest request, Integer commentId){
        return ResponseEntity.ok(service.updateComment(request, commentId));
    }



    @DeleteMapping("delete")
    public ResponseEntity<?> deleteComment(@RequestParam Integer commentId){
        return ResponseEntity.ok(service.deleteComment(commentId));
    }
}
