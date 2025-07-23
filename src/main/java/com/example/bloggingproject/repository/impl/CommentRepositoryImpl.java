package com.example.bloggingproject.repository.impl;

import com.example.bloggingproject.entity.Comment;
import com.example.bloggingproject.filter.CommentFilter;
import com.example.bloggingproject.repository.CommentCompositeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentCompositeRepository {
    @Override
    public Page<Comment> findALlByFilter(CommentFilter filter) {
        return null;
    }
}
