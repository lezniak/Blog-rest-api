package com.springboot.blog.blog_rest_api.service.impl;

import com.springboot.blog.blog_rest_api.dto.comment.CommentDto;
import com.springboot.blog.blog_rest_api.model.Comment;
import com.springboot.blog.blog_rest_api.repository.CommentRepository;
import com.springboot.blog.blog_rest_api.repository.PostRepository;
import com.springboot.blog.blog_rest_api.service.CommentService;

public class CommentServiceImplementation implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImplementation(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment newComment = commentDto.convert();
        Comment insertedComment = commentRepository.save(newComment);

        return insertedComment.convert();
    }
}
