package com.example.bloggingproject.dto.response;

import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    private String description;
    private Post post;
    private User user;
}
