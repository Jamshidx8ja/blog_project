package com.example.bloggingproject.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String name;
    private LocalDateTime createdAt;

}
