package com.springboot.blog.blog_rest_api.service.impl;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.model.Post;
import com.springboot.blog.blog_rest_api.repository.PostRepository;
import com.springboot.blog.blog_rest_api.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PostServiceImplementation implements PostService {
    private PostRepository postRepository;

    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = postDto.convert();
        Post createdPost = postRepository.save(newPost);

        PostDto newPostDto = createdPost.convert();
        return newPostDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postsList = postRepository.findAll();
        return postsList.stream().map(Post::convert).toList();
    }
}
