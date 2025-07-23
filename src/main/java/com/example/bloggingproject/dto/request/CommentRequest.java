package com.example.bloggingproject.dto.request;

import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequest {
    @NotBlank
    private String description;

    private Integer postId;
    private Integer userId;
}
