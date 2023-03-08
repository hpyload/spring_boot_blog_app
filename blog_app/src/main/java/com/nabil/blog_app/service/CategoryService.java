package com.nabil.blog_app.service;

import com.nabil.blog_app.dto.CategoryDto;

import java.util.List;

/**
 * @author nabil
 * @at 3/8/23 9:46 PM
 */
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long categoryId);
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    void deleteCategory(Long categoryId);
}
