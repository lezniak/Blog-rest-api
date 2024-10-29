package com.springboot.blog.blog_rest_api.service.impl;

import com.springboot.blog.blog_rest_api.dto.PostDto;
import com.springboot.blog.blog_rest_api.dto.PostResponse;
import com.springboot.blog.blog_rest_api.exception.ResourceNotFoundException;
import com.springboot.blog.blog_rest_api.model.Post;
import com.springboot.blog.blog_rest_api.repository.PostRepository;
import com.springboot.blog.blog_rest_api.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = Sort.by(sortBy);
        if (sortDir.equalsIgnoreCase("asc"))
            sort = sort.ascending();
        else
            sort = sort.descending();

        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> postsList = postRepository.findAll(pageable);
        List<Post> listOfPosts = postsList.getContent();
        List<PostDto> content = listOfPosts.stream().map(Post::convert).toList();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(pageNo);
        postResponse.setPageSize(postsList.getSize());
        postResponse.setTotalElements(postsList.getTotalElements());
        postResponse.setTotalPages(postsList.getTotalPages());
        postResponse.setLast(postsList.isLast());

        return postResponse;
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
