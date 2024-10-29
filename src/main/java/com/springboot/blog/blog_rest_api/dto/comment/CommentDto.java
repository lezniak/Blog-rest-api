package com.springboot.blog.blog_rest_api.dto.comment;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
