package com.example.bloggingproject.dto.response;

import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.entity.enums.Reaction;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeResponse {
    private Reaction reaction;
    private User user;
    private Post post;
}
