package com.example.bloggingproject.controller;

import com.example.bloggingproject.dto.request.LikeRequest;
import com.example.bloggingproject.dto.request.PostRequest;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.filter.PostFilter;
import com.example.bloggingproject.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v2/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @GetMapping("list")
    public ResponseEntity<?> getPostsList(PostFilter filter){
        return ResponseEntity.ok(service.getPostsList(filter));
    }

    @PostMapping("create")
    public ResponseEntity<?> createPost(@RequestBody PostRequest request){
        return ResponseEntity.ok(service.createPost(request));
    }

    @PostMapping("react")
    public ResponseEntity<?> reaction(@RequestBody LikeRequest request){
        return ResponseEntity.ok(service.react(request));
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<?> updatePost(@RequestBody PostRequest request, @PathVariable Integer userId){
        return ResponseEntity.ok(service.updatePost(request, userId));
    }

    @DeleteMapping("delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId){
        return ResponseEntity.ok(service.deletePost(postId));
    }

}
