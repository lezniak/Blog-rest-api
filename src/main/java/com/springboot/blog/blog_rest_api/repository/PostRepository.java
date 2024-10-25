package com.springboot.blog.blog_rest_api.repository;

import com.springboot.blog.blog_rest_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
