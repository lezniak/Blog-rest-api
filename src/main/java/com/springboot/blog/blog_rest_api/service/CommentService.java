package com.springboot.blog.blog_rest_api.service;

import com.springboot.blog.blog_rest_api.dto.comment.CommentDto;

public interface CommentService {
    public CommentDto createComment(long postId,CommentDto commentDto);
}
