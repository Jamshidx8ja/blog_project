package com.example.bloggingproject.filter;

import com.example.bloggingproject.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostFilter extends BaseFilter {

    private Integer userId;
    private SortType sortType;
    private LocalDate from;
    private LocalDate to;
}
