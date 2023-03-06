package com.nabil.blog_app.repository;

import com.nabil.blog_app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author nabil
 * @at 3/5/23 10:35 PM
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
