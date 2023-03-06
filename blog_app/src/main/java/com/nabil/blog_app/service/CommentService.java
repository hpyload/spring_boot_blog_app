package com.nabil.blog_app.service;

import com.nabil.blog_app.dto.CommentDto;

import java.util.List;

/**
 * @author nabil
 * @at 3/5/23 10:46 PM
 */
public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Long postId);
    List<CommentDto>getCommentsByPostId(Long postId);
    CommentDto getCommentById(Long postId, Long commentId);
    CommentDto updateComment(CommentDto commentDto, Long postId, Long commentId);
    void deleteComment(Long PostId, Long commentId);
}
