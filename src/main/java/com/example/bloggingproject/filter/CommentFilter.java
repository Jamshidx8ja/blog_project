package com.example.bloggingproject.filter;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
public class CommentFilter {
    private Integer size = 10;
    private Integer page = 0;
    private String searchKey;
    private Integer postId;
}
