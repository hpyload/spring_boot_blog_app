package com.nabil.blog_app.service;

import com.nabil.blog_app.dto.PostDto;
import com.nabil.blog_app.response.PostResponse;

import java.util.List;

/**
 * @author nabil
 * @at 2/11/23 10:42 PM
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortOrder);
    PostDto getPostById(Long postId);
    PostDto updatePost(PostDto postDto, Long postId);
    void deletePost(Long postId);
    List<PostDto> getPostsByCategoryId(Long categoryId);
}
