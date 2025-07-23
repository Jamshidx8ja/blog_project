package com.example.bloggingproject.repository;

import com.example.bloggingproject.entity.Comment;
import com.example.bloggingproject.filter.CommentFilter;
import org.springframework.data.domain.Page;

public interface CommentCompositeRepository {
    Page<Comment> findALlByFilter(CommentFilter filter);
}
