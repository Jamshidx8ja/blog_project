package com.example.bloggingproject.repository;

import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.filter.UserFilter;
import org.springframework.data.domain.Page;

public interface UserCompositeRepository {
    Page<User> findAllByFilter(UserFilter filter);
}
