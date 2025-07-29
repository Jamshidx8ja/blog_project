package com.example.bloggingproject.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentFilter extends BaseFilter {
    private Integer postId;
}
