package com.example.bloggingproject.repository;

import com.example.bloggingproject.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CommentCompositeRepository {

    List<Comment> findAllByPostId(Integer postId);
}
