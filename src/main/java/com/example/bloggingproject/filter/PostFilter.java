package com.example.bloggingproject.filter;

import com.example.bloggingproject.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFilter {
    private Integer size = 10;
    private Integer page = 0;
    private String searchKey;

    private Integer userId;
    private SortType sortType;

}
