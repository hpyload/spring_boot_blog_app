package com.nabil.blog_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static com.nabil.blog_app.util.Constants.*;

/**
 * @author nabil
 * @at 2/11/23 10:37 PM
 */
@Setter
@Getter
public class PostDto {
    private Long id;
    @NotEmpty(message = NOT_EMPTY_TITLE)
    @Size(min = 2, message = SIZE_TITLE)
    private String title;
    @NotEmpty(message = NOT_EMPTY_DESCRIPTION)
    @Size(min = 10, message = SIZE_DESCRIPTION)
    private String description;
    @NotEmpty(message = NOT_EMPTY_CONTENT)
    private String content;
    private Set<CommentDto> comments;
    private Long categoryId;
}
