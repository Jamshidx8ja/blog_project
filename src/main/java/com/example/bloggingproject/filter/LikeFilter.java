package com.example.bloggingproject.filter;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
public class LikeFilter {
    private Integer size = 10;
    private Integer page = 0;
    private String searchKey;
}
