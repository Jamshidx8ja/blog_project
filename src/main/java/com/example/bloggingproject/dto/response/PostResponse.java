package com.example.bloggingproject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
    private String user;
    private String title;
    private String description;
    private Integer likesCount = 0;
    private Integer dislikesCount = 0;
}

