package com.example.bloggingproject.repository.impl;

import com.example.bloggingproject.entity.Comment;
import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.filter.CommentFilter;
import com.example.bloggingproject.filter.PostFilter;
import com.example.bloggingproject.repository.CommentCompositeRepository;
import com.example.bloggingproject.repository.PostCompositeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostCompositeRepository {
    @Override
    public Page<Post> findALlByFilter(PostFilter filter) {
        return null;
    }
}
