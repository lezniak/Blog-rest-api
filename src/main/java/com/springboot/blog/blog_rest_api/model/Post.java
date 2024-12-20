package com.springboot.blog.blog_rest_api.model;

import com.springboot.blog.blog_rest_api.dto.post.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title","id"})}
)
public class Post extends AuditableEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "tittle",nullable = false)
    private String tittle;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "content",nullable = false)
    private String content;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();


    public PostDto convert(){
        PostDto convertedPostDto = new PostDto();
        convertedPostDto.setId(getId());
        convertedPostDto.setTittle(getTittle());
        convertedPostDto.setDesc(getDescription());
        convertedPostDto.setContent(getContent());
        return convertedPostDto;
    }
}
