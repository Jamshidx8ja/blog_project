package com.example.bloggingproject.mapstruct;

import com.example.bloggingproject.dto.request.PostRequest;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {


    Post toEntity(PostRequest postRequest);

    @Mapping(target = "user", expression = "java(post.getUserName())")
    PostResponse toResponse(Post post);

}
