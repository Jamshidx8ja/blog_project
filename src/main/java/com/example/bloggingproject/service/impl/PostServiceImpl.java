package com.example.bloggingproject.service.impl;

import com.example.bloggingproject.dto.request.LikeRequest;
import com.example.bloggingproject.dto.request.PostRequest;
import com.example.bloggingproject.dto.response.PostResponse;
import com.example.bloggingproject.entity.Like;
import com.example.bloggingproject.entity.Post;
import com.example.bloggingproject.entity.User;
import com.example.bloggingproject.entity.enums.Reaction;
import com.example.bloggingproject.filter.PostFilter;
import com.example.bloggingproject.repository.LikeRepository;
import com.example.bloggingproject.repository.PostRepository;
import com.example.bloggingproject.repository.UserRepository;
import com.example.bloggingproject.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    @Override
    public List<PostResponse> getPostsList(PostFilter filter) {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::toResponse).toList();
    }

    @Override
    public Object createPost(PostRequest request) {
        Post post = new Post();
        toEntity(request, post);
        User user = userRepository.findById(request.getUserId()).orElseThrow(EntityNotFoundException::new);
        post.setUser(user);
        postRepository.save(post);

        return toResponse(post);
    }

    @Override
    public Object updatePost(PostRequest request, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.save(post);

        return toResponse(post);
    }

    @Override
    public Object deletePost(Integer postId) {
        postRepository.deleteById(postId);

        return "Post deleted";
    }

    @Override
    public Object react(LikeRequest request) {
//        Post post = postRepository.findById(request.getPost().getId())
//                .orElseThrow(() -> new RuntimeException("Post not found"));
//        User user = userRepository.findById(request.getUser().getId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Optional<Like> likeExists = likeRepository.findByUserAndPost(user, post);
//
//        if (likeExists.isPresent()) {
//            Like like = likeExists.get();
//
//            if (like.getReaction() == request.getReaction()) {
//                likeRepository.delete(like);
//                updateReactionCount(post, request.getReaction(), -1);
//            } else {
//                updateReactionCount(post, like.getReaction(), -1);
//                updateReactionCount(post, request.getReaction(), 1);
//                like.setReaction(request.getReaction());
//                likeRepository.save(like);
//            }
//        } else {
//            Like like = new Like();
//            like.setPost(request.getPost());
//            like.setUser(request.getUser());
//            like.setReaction(request.getReaction());
//            likeRepository.save(like);
//            updateReactionCount(post, request.getReaction(), 1);
//        }
//        postRepository.save(post);
//        return toResponse(post);
        return null;
    }

    private PostResponse toResponse(Post post) {
        if (post == null) return null;

        PostResponse response = new PostResponse();
        response.setUser(post.getUser().getName());
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setLikesCount(post.getLikesCount());
        response.setDislikesCount(post.getDislikesCount());

        return response;
    }

    private void toEntity(PostRequest request, Post post) {
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());

    }

    private void updateReactionCount(Post post, Reaction reaction, int one) {
        if (reaction == Reaction.LIKE) {
            post.setLikesCount(post.getLikesCount() + one);
        } else if (reaction == Reaction.DISLIKE) {
            post.setDislikesCount(post.getDislikesCount() + one);
        }
    }
}
