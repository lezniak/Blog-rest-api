package com.springboot.blog.blog_rest_api.service;

import com.springboot.blog.blog_rest_api.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
}
