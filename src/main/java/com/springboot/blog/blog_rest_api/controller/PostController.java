package com.springboot.blog.blog_rest_api.controller;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;
import com.springboot.blog.blog_rest_api.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;

    @PostMapping
    @RequestMapping("new")
    private ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping
    @RequestMapping("{id}")
    private ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PutMapping
    @RequestMapping("update/{id}")
    private ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(postService.updatePostById(postDto,id));
    }

    @DeleteMapping
    @RequestMapping("delete/{id}")
    private ResponseEntity<String> deletePostById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        postService.deletePostById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
