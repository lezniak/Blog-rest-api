package com.springboot.blog.blog_rest_api.controller;

import com.springboot.blog.blog_rest_api.dto.post.PostDto;
import com.springboot.blog.blog_rest_api.dto.post.PostResponse;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;
import com.springboot.blog.blog_rest_api.service.PostService;
import com.springboot.blog.blog_rest_api.utils.AppConstrants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstrants.DEFAULT_PAGE_NUM,required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstrants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstrants.DEFAULT_PAGE_SIZE, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstrants.DEFAULT_SORT_DIR,required = false) String sortDir
    ){
        return ResponseEntity.ok(postService.getAllPosts(pageNo,pageSize,sortBy,sortDir));
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
