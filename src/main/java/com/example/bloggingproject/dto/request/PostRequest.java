package com.example.bloggingproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequest {

    private Integer userId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

}
