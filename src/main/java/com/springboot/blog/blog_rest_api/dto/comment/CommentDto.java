package com.springboot.blog.blog_rest_api.dto.comment;

import com.springboot.blog.blog_rest_api.model.Comment;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;


    public Comment convert(){
        Comment newComment = new Comment();
        newComment.setBody(getBody());
        newComment.setEmail(getEmail());
        newComment.setName(getName());

        return newComment;
    }
}
