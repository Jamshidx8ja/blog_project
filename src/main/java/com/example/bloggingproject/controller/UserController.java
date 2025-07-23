package com.example.bloggingproject.controller;

import com.example.bloggingproject.dto.request.UserRequest;
import com.example.bloggingproject.filter.UserFilter;
import com.example.bloggingproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("list")
    public ResponseEntity<?> getUsersList(UserFilter filter){
        return ResponseEntity.ok(service.getUsersList(filter));
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest request){
        return ResponseEntity.ok(service.createUser(request));
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest request, @PathVariable Integer userId){
        return ResponseEntity.ok(service.updateUser(request, userId));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer userId){
        return ResponseEntity.ok(service.deleteUser(userId));
    }
}
