package com.springboot.blog.blog_rest_api.dto;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String tittle;
    private String desc;
    private String content;
}
