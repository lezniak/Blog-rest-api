package com.springboot.blog.blog_rest_api.service.impl;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;
import com.springboot.blog.blog_rest_api.model.Post;
import com.springboot.blog.blog_rest_api.repository.PostRepository;
import com.springboot.blog.blog_rest_api.service.PostService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImplementation implements PostService {
    private PostRepository postRepository;

    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = postDto.convert();
        Post createdPost = postRepository.save(newPost);

        PostDto newPostDto = createdPost.convert();
        return newPostDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postsList = postRepository.findAll();
        return postsList.stream().map(Post::convert).toList();
    }

    @Override
    public PostDto getPost(Long id) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        return post.convert();
    }

    @Override
    public PostDto updatePostById(PostDto postDto, Long id) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        post.setTittle(postDto.getTittle());
        post.setDescription(postDto.getDesc());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return updatedPost.convert();
    }

    @Override
    public void deletePostById(Long id) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }
}
