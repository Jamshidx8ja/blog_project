package com.example.bloggingproject.dto.request;

import com.example.bloggingproject.entity.enums.Reaction;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LikeRequest {
    @NotBlank
    private Reaction reaction;
    private Integer postId;
    private Integer userId;
}
