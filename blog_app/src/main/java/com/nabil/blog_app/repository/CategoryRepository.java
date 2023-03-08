package com.nabil.blog_app.repository;

import com.nabil.blog_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nabil
 * @at 3/8/23 9:42 PM
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
