package com.springboot.blog.blog_rest_api.service;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPost(Long id) throws ResourceNotFoundException;
}
