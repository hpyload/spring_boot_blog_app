package com.nabil.blog_app.repository;

import com.nabil.blog_app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author nabil
 * @at 2/11/23 10:07 PM
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Long categoryId);
}
