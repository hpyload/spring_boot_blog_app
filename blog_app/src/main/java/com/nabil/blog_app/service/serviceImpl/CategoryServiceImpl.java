package com.nabil.blog_app.service.serviceImpl;

import com.nabil.blog_app.dto.CategoryDto;
import com.nabil.blog_app.entity.Category;
import com.nabil.blog_app.exception.ResourceNotFoundException;
import com.nabil.blog_app.repository.CategoryRepository;
import com.nabil.blog_app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.nabil.blog_app.util.Constants.CATEGORY_RESOURCE_NAME;
import static com.nabil.blog_app.util.Constants.FIELD_NAME;

/**
 * @author nabil
 * @at 3/8/23 9:50 PM
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return mapToDto(categoryRepository.save(mapToEntity(categoryDto)));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        return mapToDto(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, categoryId)));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, categoryId));
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return mapToDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.delete(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_RESOURCE_NAME, FIELD_NAME, categoryId)));
    }

    private CategoryDto mapToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category mapToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
