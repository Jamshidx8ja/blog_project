package com.example.bloggingproject.service.impl;

import com.example.bloggingproject.dto.request.UserRequest;
import com.example.bloggingproject.dto.response.UserResponse;
import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.filter.UserFilter;
import com.example.bloggingproject.repository.UserRepository;
import com.example.bloggingproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.security.cert.URICertStoreParameters;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getUsersList(UserFilter userFilter) {
        return userRepository.findAllByFilter(userFilter)
                .getContent().stream().map(this::toResponse).toList();
    }

    @Override
    public Object createUser(UserRequest request) {
        User user = new User();
        toEntity(request, user);
        userRepository.save(user);
        return toResponse(user);
    }

    @Override
    public Object updateUser(UserRequest request, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();
        toEntity(request, user);
        userRepository.save(user);
        return toResponse(user);
    }

    @Override
    public Object deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        return "User successfully deleted";
    }

    private UserResponse toResponse(User user) {
        if (user == null) return null;

        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setId(user.getId());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }

    private void toEntity(UserRequest request, User user) {
        user.setName(request.getName());
    }
}
