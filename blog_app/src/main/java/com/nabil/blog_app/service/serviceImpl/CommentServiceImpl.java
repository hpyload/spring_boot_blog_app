package com.nabil.blog_app.service.serviceImpl;

import com.nabil.blog_app.dto.CommentDto;
import com.nabil.blog_app.entity.Comment;
import com.nabil.blog_app.entity.Post;
import com.nabil.blog_app.exception.BlogApiException;
import com.nabil.blog_app.exception.ResourceNotFoundException;
import com.nabil.blog_app.repository.CommentRepository;
import com.nabil.blog_app.repository.PostRepository;
import com.nabil.blog_app.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.nabil.blog_app.util.Constants.*;


/**
 * @author nabil
 * @at 3/5/23 10:55 PM
 */
@Service
public class CommentServiceImpl implements CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId));
        comment.setPost(post);
        return mapToDto(commentRepository.save(comment));
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_RESOURCE_NAME, FIELD_NAME, commentId));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId));
        if (!post.getId().equals(comment.getPost().getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_RESOURCE_NAME, FIELD_NAME, commentId));
        if (!post.getId().equals(comment.getPost().getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return mapToDto(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE_NAME, FIELD_NAME, postId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_RESOURCE_NAME, FIELD_NAME, commentId));
        if (!post.getId().equals(comment.getPost().getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }
        commentRepository.deleteById(commentId);
    }

    public CommentDto mapToDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }

    public Comment mapToEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, Comment.class);
    }
}
