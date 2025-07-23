package com.example.bloggingproject.repository;

import com.example.bloggingproject.entity.Like;
import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    Optional<Like> findByUserAndPost(User user, Post post);
}
