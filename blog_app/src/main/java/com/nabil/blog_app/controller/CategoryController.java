package com.nabil.blog_app.controller;

import com.nabil.blog_app.dto.CategoryDto;
import com.nabil.blog_app.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 3/8/23 10:19 PM
 */
@RestController
@RequestMapping(APP_ROOT)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(CATEGORY_ENDPOINT)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping(CATEGORY_ENDPOINT)
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(PATH_CATEGORY_ID)
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = PATH_VARIABLE_CATEGORY_ID) Long categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }

    @PutMapping(PATH_CATEGORY_ID)
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                      @PathVariable(value = PATH_VARIABLE_CATEGORY_ID) Long categoryId) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, categoryId), HttpStatus.OK);
    }

    @DeleteMapping(PATH_CATEGORY_ID)
    public ResponseEntity<String> deleteCategory(@PathVariable(value = PATH_VARIABLE_CATEGORY_ID) Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(CATEGORY_DELETE_INFO, HttpStatus.OK);
    }
}
