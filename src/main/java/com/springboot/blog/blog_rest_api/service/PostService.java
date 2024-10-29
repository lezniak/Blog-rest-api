package com.springboot.blog.blog_rest_api.service;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.dto.PostResponse;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPost(Long id) throws ResourceNotFoundException;
    PostDto updatePostById(PostDto postDto,Long id) throws ResourceNotFoundException;
    void deletePostById(Long id) throws ResourceNotFoundException;
}
