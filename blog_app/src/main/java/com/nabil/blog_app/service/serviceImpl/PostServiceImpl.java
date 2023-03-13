package com.nabil.blog_app.service.serviceImpl;

import com.nabil.blog_app.dto.PostDto;
import com.nabil.blog_app.entity.Category;
import com.nabil.blog_app.entity.Post;
import com.nabil.blog_app.exception.ResourceNotFoundException;
import com.nabil.blog_app.repository.CategoryRepository;
import com.nabil.blog_app.repository.PostRepository;
import com.nabil.blog_app.response.PostResponse;
import com.nabil.blog_app.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 2/11/23 10:50 PM
 */
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,
                           CategoryRepository categoryRepository,
                           ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, postDto.getCategoryId()));
        Post post = mapToEntity(postDto);
        post.setCategory(category);
        return mapToDto(postRepository.save(post));
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize,String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        // create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);
        //get content for page object
        List<Post> listOfPosts = posts.getContent();
        List<PostDto> content = listOfPosts.stream().map(this::mapToDto).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Long postId) {
        return mapToDto(postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId)));
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, postDto.getCategoryId()));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setCategory(category);
        return mapToDto(postRepository.save(post));
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.delete(postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId)));
    }

    @Override
    public List<PostDto> getPostsByCategoryId(Long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, categoryId));
        List<Post> posts = postRepository.findByCategoryId(categoryId);
        return posts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private PostDto mapToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    private Post mapToEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }
}
