package com.example.bloggingproject.mapstruct;

import com.example.bloggingproject.dto.request.UserRequest;
import com.example.bloggingproject.dto.response.UserResponse;
import com.example.bloggingproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toEntity(UserRequest request);

    UserResponse toResponse(User user);
    void  updateEntity(UserRequest userRequest, @MappingTarget User user);
}
