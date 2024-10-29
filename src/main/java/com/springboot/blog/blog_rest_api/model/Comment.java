package com.springboot.blog.blog_rest_api.model;

import com.springboot.blog.blog_rest_api.dto.comment.CommentDto;
import com.springboot.blog.blog_rest_api.dto.post.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "body",nullable = false)
    private String body;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

    public CommentDto convert(){
        CommentDto commentDto = new CommentDto();
        commentDto.setBody(getBody());
        commentDto.setId(getId());
        commentDto.setName(getName());
        commentDto.setEmail(getEmail());

        return commentDto;
    }
}
