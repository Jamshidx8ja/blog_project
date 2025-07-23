package com.example.bloggingproject.service;

import com.example.bloggingproject.dto.request.CommentRequest;
import com.example.bloggingproject.dto.response.CommentResponse;
import com.example.bloggingproject.dto.response.LikeResponse;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.filter.CommentFilter;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getCommentsList(CommentFilter filter);
    Object createComment(CommentRequest request);
    Object updateComment(CommentRequest request, Integer commentId);
    Object deleteComment(Integer commentId);

}
