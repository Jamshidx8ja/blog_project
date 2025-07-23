package com.example.bloggingproject.repository;

import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.filter.PostFilter;
import org.springframework.data.domain.Page;

public interface PostCompositeRepository {
    Page<Post> findALlByFilter(PostFilter filter);
}
