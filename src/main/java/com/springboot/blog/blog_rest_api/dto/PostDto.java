package com.springboot.blog.blog_rest_api.dto;

import com.springboot.blog.blog_rest_api.model.Post;
import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String tittle;
    private String desc;
    private String content;

    public Post convert(){
        Post convertedPost = new Post();
        convertedPost.setTittle(getTittle());
        convertedPost.setContent(getContent());
        convertedPost.setDescription(getDesc());
        return convertedPost;
    }
}
