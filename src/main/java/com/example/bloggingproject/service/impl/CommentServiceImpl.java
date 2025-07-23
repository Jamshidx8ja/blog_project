package com.example.bloggingproject.service.impl;

import com.example.bloggingproject.dto.request.CommentRequest;
import com.example.bloggingproject.dto.response.CommentResponse;
import com.example.bloggingproject.dto.response.LikeResponse;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.entity.Comment;
import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.filter.CommentFilter;
import com.example.bloggingproject.repository.CommentRepository;
import com.example.bloggingproject.repository.PostRepository;
import com.example.bloggingproject.repository.UserRepository;
import com.example.bloggingproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public List<CommentResponse> getCommentsList(CommentFilter filter) {
        List<Comment> allByPostId = commentRepository.findAllByPostId(filter.getPostId());
        return allByPostId.stream().map(this::toResponse).toList();
    }

    @Override
    public Object createComment(CommentRequest request) {
        Comment comment = new Comment();
        toEntity(request, comment);
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        comment.setUser(user);
        comment.setPost(postRepository.findById(request.getPostId()).orElseThrow());
        commentRepository.save(comment);

        return toResponse(comment);
    }

    @Override
    public Object updateComment(CommentRequest request, Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.save(comment);
        return toResponse(comment);
    }

    @Override
    public Object deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
        return "Comment deleted";
    }


    private CommentResponse toResponse(Comment comment) {
        if (comment == null) return null;

        CommentResponse response = new CommentResponse();
        response.setUser(comment.getUser());
        response.setPost(comment.getPost());
        response.setDescription(comment.getDescription());

        return response;
    }

    private void toEntity(CommentRequest request, Comment comment) {
        comment.setDescription(request.getDescription());
    }
}
