package com.example.bloggingproject.service;

import com.example.bloggingproject.dto.request.LikeRequest;
import com.example.bloggingproject.dto.request.PostRequest;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.enums.Reaction;
import com.example.bloggingproject.filter.PostFilter;

import java.util.List;

public interface PostService {
    List<PostResponse> getPostsList(PostFilter filter);
    Object createPost(PostRequest request);
    Object updatePost(PostRequest request, Integer postId);
    Object deletePost(Integer postId);
    Object react(LikeRequest request);
}
