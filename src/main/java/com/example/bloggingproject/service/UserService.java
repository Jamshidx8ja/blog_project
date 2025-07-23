package com.example.bloggingproject.service;

import com.example.bloggingproject.dto.request.UserRequest;
import com.example.bloggingproject.dto.response.UserResponse;
import com.example.bloggingproject.filter.UserFilter;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsersList(UserFilter userFilter);
    Object createUser(UserRequest request);
    Object updateUser(UserRequest request, Integer userId);
    Object deleteUser(Integer userId);

}
